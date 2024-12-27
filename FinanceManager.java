package gitzuoye;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinanceManager {
    private List<Transaction> transactions = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addIncome() {
        System.out.print("输入收入日期（格式：YYYY-MM-DD）：");
        String date = scanner.nextLine();
        System.out.print("输入收入金额：");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // 消费回车
        System.out.print("输入收入类别：");
        String category = scanner.nextLine();
        System.out.print("输入收入备注：");
        String description = scanner.nextLine();

        transactions.add(new Transaction(date, amount, "Income", description));
    }

    public void addExpense() {
        System.out.print("输入支出日期（格式：YYYY-MM-DD）：");
        String date = scanner.nextLine();
        System.out.print("输入支出金额：");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // 消费回车
        System.out.print("输入支出类别：");
        String category = scanner.nextLine();
        System.out.print("输入支出备注：");
        String description = scanner.nextLine();

        transactions.add(new Transaction(date, amount, "Expense", description));
    }
	//查看所有账单
    public void listTransactions() {
        System.out.println("\n所有交易记录：");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
	//月度统计
    public void summarize() {
        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getCategory().equals("Income")) {
                totalIncome += transaction.getAmount();
            } else if (transaction.getCategory().equals("Expense")) {
                totalExpense += transaction.getAmount();
            }
        }

        System.out.println("\n总收入：$" + totalIncome);
        System.out.println("总支出：$" + totalExpense);
        System.out.println("净流入：$" + (totalIncome - totalExpense));
    }
	//查询交易（按日期）
    public void queryTransactions(String date) {
        System.out.println("\n查询结果（日期：" + date + "）：");
        for (Transaction transaction : transactions) {
            if (transaction.getDate().equals(date)) {
                System.out.println(transaction);
            }
        }
    }

    public void run() {
        while (true) {
            System.out.println("\n个人财务管理系统");
            System.out.println("1. 添加收入");
            System.out.println("2. 添加支出");
            System.out.println("3. 列表所有交易");
            System.out.println("4. 总结财务情况");
            System.out.println("5. 查询交易（按日期）");
            System.out.println("6. 退出");

            System.out.print("请输入您的选择：");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消费回车

            switch (choice) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    addExpense();
                    break;
                case 3:
                    listTransactions();
                    break;
                case 4:
                    summarize();
                    break;
                case 5:
                    System.out.print("输入查询日期（格式：YYYY-MM-DD）：");
                    String queryDate = scanner.nextLine();
                    queryTransactions(queryDate);
                    break;
                case 6:
                    System.out.println("谢谢使用！退出程序。");
                    return;
                default:
                    System.out.println("无效的选择，请重新选择。");
            }
        }
    }
}
