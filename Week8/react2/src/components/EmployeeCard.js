import React from "react";
import ExpenseTable from "./ExpenseTable";
export default function EmployeeCard({employee}) {
  return (
    <>
      <div className="card-title">{employee.firstname} {employee.lastname}</div>
      <div className="card-body">
        <ExpenseTable expenses={employee.expenses} />
      </div>
    </>
  );
}
