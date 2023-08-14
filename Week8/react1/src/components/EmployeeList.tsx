import ExpenseItem, { ExpenseItemProps } from "./ExpenseItem";

export type Employee = {
  name: string;
  expenses: ExpenseItemProps[];
};

export default function EmployeeList({ employees }: { employees: Employee[] }) {
  return (
    <div>
      <h1>EmployeeList</h1>
      <table className="table table-striped table">
        <thead className="thead-dark">
          <tr className="text-center">
            <th>Name</th>
            <th>Empense</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr>
              <td>{employee.name}</td>
              <td>
                <table className="table">
                  <thead className="thead-dark">
                    <tr className="text-center">
                      <th>Date</th>
                      <th>Title</th>
                      <th>Amount</th>
                    </tr>
                  </thead>
                  {employee.expenses.map((expense) => (
                    <ExpenseItem {...expense} />
                  ))}
                  <tfoot className="tfoot-dark">
                    <tr>
                      <td colSpan={3}>Total</td>
                    </tr>
                  </tfoot>
                </table>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
