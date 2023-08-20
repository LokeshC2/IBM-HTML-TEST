import "./App.css";

import EmployeeList from "./data/EmployeeList";
import Card from "./components/Card";
import EmployeeCard from "./components/EmployeeCard";
import ExpenseForm from "./components/ExpenseForm";
import { useEffect, useState } from "react";
import ExpenseTable from "./components/ExpenseTable";

function App() {
  let local = JSON.parse(localStorage.getItem("employees"));
  let [employees, setEmployees] = useState(local || EmployeeList);

  let [firstname, setFirstname] = useState("");
  let [lastname, setLastname] = useState("");
  let [expenses, setExpenses] = useState([]);

  const addExpense = (expense) => {
    setExpenses((exps) => exps.concat(expense));
    console.log(expenses);
  };

  onsubmit = (e) => {
    e.preventDefault();
    setEmployees((prev) => prev.concat({ firstname, lastname, expenses }));
    setFirstname("");
    setLastname("");
    setExpenses([]);
  };

  useEffect(() => {
    console.log(employees);
    localStorage.setItem("employees", JSON.stringify(employees));
  }, [employees]);

  return (
    <div className="App">
      <h1 className="display-2 text-center">Expense Report</h1>
      <div className="container">
        <div className="row">
          {employees.map((employee, i) => (
            <Card key={i}>
              <EmployeeCard employee={employee} />
            </Card>
          ))}
        </div>
        <div className="form-group">
          <Card>
            <div className="row">
              <label className="col">
                First Name:{" "}
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter first name"
                  onInput={(e) => setFirstname(e.target.value)}
                />
              </label>
              <label className="col">
                Last Name:{" "}
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter last name"
                  onInput={(e) => setLastname(e.target.value)}
                />
              </label>
              <ExpenseTable expenses={expenses} />
              <Card>
                <ExpenseForm addExpense={addExpense} />
              </Card>
              <button
                type="button"
                className="btn btn-primary"
                onClick={onsubmit}
              >
                Add employee
              </button>
            </div>
          </Card>
        </div>
      </div>
    </div>
  );
}

export default App;
