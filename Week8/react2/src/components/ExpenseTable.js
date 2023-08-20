import Expense from "./Expense";
export default function ExpenseTable({expenses}) {
  return (
    <table className="table">
      <thead>
        <tr>
          <th scope="col">Date</th>
          <th scope="col">Description</th>
          <th scope="col">Amount</th>
        </tr>
      </thead>
      <tbody>
        {expenses.map((expense, i) => (
          <Expense key={i} expense={expense} />
        ))}
      </tbody>
    </table>
  );
}
