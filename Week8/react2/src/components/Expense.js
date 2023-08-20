import React from 'react'

export default function Expense({expense}) {
  return (
    <tr className='card-text row'>
      <td className='col'>{expense.date}</td>
      <td className='col'>{expense.description}</td>
      <td className='col'>{expense.amount}</td>
    </tr>
  )
}
