export type ExpenseItemProps = {
  id?: string
  title: string;
  amount: number;
  date: Date;
}

export default function ExpenseItem(props: ExpenseItemProps) {
  return (
      <tbody className="text-center">
        <tr>
          <td>{props.date.toLocaleDateString()}</td>
          <td>{props.title}</td>
          <td>{props.amount}</td>
        </tr>
      </tbody>
      

  )
}
