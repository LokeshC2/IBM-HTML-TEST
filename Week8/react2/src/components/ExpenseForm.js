import { useState } from "react";

export default function ExpenseForm({ addExpense }) {
  const [date, setDate] = useState("");
  const [description, setDescription] = useState("");
  const [amount, setAmount] = useState("");

  const onsubmit = (e) => {
    e.preventDefault();
    addExpense({ date, description, amount });
    setDate("");
    setDescription("");
    setAmount("");
  };

  return (
    <>
      <div className="card-text row">
        <input
          className="col"
          id="date"
          type="date"
          value={date}
          onInput={(e) => setDate(e.target.value)}
        />
        <input
          className="col"
          id="description"
          type="text"
          value={description}
          onInput={(e) => setDescription(e.target.value)}
        />
        <input
          className="col"
          id="amount"
          type="number"
          value={amount}
          onInput={(e) => setAmount(e.target.value)}
        />
      </div>
      <div className="col-12 d-grid gap-2">
        <button type="button" onClick={onsubmit} className="col-1 mx-auto my-2 btn btn-primary">
          +
        </button>
      </div>
    </>
  );
}
