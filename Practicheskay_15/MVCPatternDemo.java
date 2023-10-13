package Practicheskay_15;

public class MVCPatternDemo {
    public static void main(String[] args) {
        // Создаем модель
        Employee model = new Employee("John Doe", 50000);

        // Создаем представление
        EmployeeView view = new EmployeeView();

        // Создаем контроллер
        EmployeeController controller = new EmployeeController(model, view);

        // Выводим начальные данные
        controller.updateView();

        // Изменяем модель и обновляем представление
        controller.setEmployeeName("Jane Smith");
        controller.setEmployeeSalary(60000);
        controller.updateView();
    }
}

