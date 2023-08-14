import './App.css'
import EmployeeList from './components/EmployeeList'
import {employees} from './data'

function App() {

  return (
    <div className="App">
      <EmployeeList employees={employees} />
    </div>
  )
}

export default App
