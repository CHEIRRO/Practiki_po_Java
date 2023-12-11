package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;


public class Tetris extends JPanel
{

    private final Point[][][] Tetraminos = {
            // I-Фигура
            {
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)},
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)}
            },

            // J-Фигура
            {
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2)},
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0)}
            },

            // L-Фигура
            {
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2)},
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0)}
            },

            // O-Фигура
            {
                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)}
            },

            // S-Фигура
            {
                    {new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)},
                    {new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)}
            },

            // T-Фигура
            {
                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1)},
                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)},
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2)},
                    {new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2)}
            },

            // Z-Фигура
            {
                    {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)},
                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2)},
                    {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)},
                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2)}
            }
    };

    private final Color[] tetraminoColors = {
            Color.cyan, Color.blue, Color.orange, Color.yellow, Color.green, Color.pink, Color.red
    };

    private Point pieceOrigin;
    private int currentPiece;
    private int rotation;
    private final ArrayList<Integer> nextPieces = new ArrayList<Integer>();
    private long score;
    private long lines;
    private Color[][] well;
    private static boolean isPaused = false;


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Создает границу вокруг поля и инициализирует падающую фигуру
    private void init()
    {
        well = new Color[12][24];
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 23; j++)
            {
                if (i == 0 || i == 11 || j == 22)
                    well[i][j] = Color.GRAY;
                else
                    well[i][j] = Color.BLACK;
            }
        }
        newPiece();
    }

    // Помещает новую случайную фигуру в позицию для падения
    public void newPiece()
    {
        pieceOrigin = new Point(5, 2);
        rotation = 0;
        if (nextPieces.isEmpty())
        {
            Collections.addAll(nextPieces, 0, 1, 2, 3, 4, 5, 6);
            Collections.shuffle(nextPieces);
        }
        currentPiece = nextPieces.get(0);
        nextPieces.remove(0);
    }

    // Проверка на столкновение при данной позиции и вращении фигуры
    private boolean collidesAt(int x, int y, int rotation)
    {
        for (Point p : Tetraminos[currentPiece][rotation])
        {
            if (well[p.x + x][p.y + y] != Color.BLACK)
                return false;
        }
        return true;
    }

    // Закрепляет падающую фигуру в поле, чтобы можно было проводить проверку на столкновения
    public void fixToWell()
    {
        if(checkGameOver())
            gameOver();

        for (Point p : Tetraminos[currentPiece][rotation])
        {
            well[pieceOrigin.x + p.x][pieceOrigin.y + p.y] = tetraminoColors[currentPiece];
        }
        clearRows();
        newPiece();
    }

    // Рисует падающую фигуру
    private void drawPiece(Graphics g)
    {
        g.setColor(tetraminoColors[currentPiece]);
        for (Point p : Tetraminos[currentPiece][rotation])
        {
            g.fillRect((p.x + pieceOrigin.x) * 26, (p.y + pieceOrigin.y) * 26, 25, 25);
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        // Заполняет поле
        g.fillRect(0, 0, 26 * 12, 26 * 23);
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 23; j++)
            {
                g.setColor(well[i][j]);
                g.fillRect(26 * i, 26 * j, 25, 25);
            }
        }

        // Отрисовка правой области
        g.setColor(Color.WHITE);
        g.fillRect(26 * 12, 0, 100, 26 * 23);

        // Отображает счет
        g.setColor(Color.BLACK);
        Font scoreFont = new Font("Arial", Font.BOLD, 13);
        g.setFont(scoreFont);
        g.drawString("Score: " + score, 318, 280);

        // Отображает линии
        g.setColor(Color.BLACK);
        Font LinesFont = new Font("Arial", Font.BOLD, 13);
        g.setFont(LinesFont);
        g.drawString("Lines: " + lines, 318, 300);

        // Рисует падающую фигуру
        drawPiece(g);
    }


    public void keyPressed(KeyEvent e)
    {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    rotate(+1);
                    break;
                case KeyEvent.VK_DOWN:
                    dropDown();
                    score += 1;
                    break;
                case KeyEvent.VK_LEFT:
                    move(-1);
                    break;
                case KeyEvent.VK_RIGHT:
                    move(+1);
                    break;
                case KeyEvent.VK_1:
                    togglePause();
                    break;
            }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Метод для проверки завершения игры
    private boolean checkGameOver()
    {
        for (Point p : Tetraminos[currentPiece][rotation])
        {
            int y = p.y + pieceOrigin.y;
            // Проверяем, достигла ли падающая фигура верхней границы поля
            if (y == 5)
                return true;
        }
        return false;
    }

    // Метод для обработки завершения игры
    private void gameOver()
    {
        isPaused = true;

        JOptionPane.showMessageDialog(this, "Игра окончена. Ваш счет: " + score);

        //restartGame();
        System.exit(0);
    }

    //Пауза
    public void togglePause() {
        isPaused = !isPaused;
    }

    // Поворот фигуры по часовой
    public void rotate(int i)
    {
        if (!isPaused)
        {
            int newRotation = (rotation + i) % 4;

            if (newRotation < 0)
                newRotation = 3;

            if (collidesAt(pieceOrigin.x, pieceOrigin.y, newRotation))
                rotation = newRotation;

            repaint();
        }
    }

    // Перемещение фигуры влево или вправо
    public void move(int i)
    {
        if (!isPaused && collidesAt(pieceOrigin.x + i, pieceOrigin.y, rotation))
            pieceOrigin.x += i;

        repaint();
    }


    // Опускание фигуры на одну линию или закрепление ее в поле, если она не может опуститься
    public void dropDown()
    {
        if (!isPaused)
        {

            if (collidesAt(pieceOrigin.x, pieceOrigin.y + 1, rotation)) {
                pieceOrigin.y += 1;
            } else {
                fixToWell();
            }
            repaint();
        }
    }


    // Удаляет завершенные строки с поля и начисляет очки в зависимости от количества одновременно удаленных строк
    public void clearRows()
    {
        boolean gap;
        int numClears = 0;

        for (int j = 21; j > 0; j--)
        {
            gap = false;
            for (int i = 1; i < 11; i++)
            {
                if (well[i][j] == Color.BLACK)
                {
                    gap = true;
                    break;
                }
            }
            if (!gap)
            {
                deleteRow(j);
                j += 1;
                numClears += 1;
            }
        }

        switch (numClears)
        {
            case 1 -> score += 100;
            case 2 -> score += 300;
            case 3 -> score += 500;
            case 4 -> score += 800;
        }

        switch (numClears)
        {
            case 1 -> lines += 1;
            case 2 -> lines += 2;
            case 3 -> lines += 3;
            case 4 -> lines += 4;
        }
    }

    // Удаляет строку по указанному номеру
    public void deleteRow(int row)
    {
        for (int j = row - 1; j > 0; j--)
        {
            for (int i = 1; i < 11; i++)
            {
                well[i][j + 1] = well[i][j];
            }
        }
    }

    ////////////////////////////////////////////    MAIN    ////////////////////////////////////////////

    public static void main(String[] args)
    {
        JFrame f = new JFrame("Тетрис");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(12 * 26 + 100, 26 * 23 + 35);
        f.setVisible(true);

        final Tetris game = new Tetris();
        game.init();
        f.add(game);

        // Управление с клавиатуры
        f.addKeyListener(new KeyListener()
        {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                game.keyPressed(e);
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        // Падение фигуры каждые пол секунды
        new Thread()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    try {
                        Thread.sleep(500);
                        game.dropDown();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }.start();
    }
}
