import './App.css';
import React, {useState} from 'react';
import CustomerRequestForm from "../components/CustomerRequestForm";
import CreateCustomer from "../components/CreateCustomer";
import CreateAccount from "../components/CreateAccount";


function App() {

    const getCustomers = async () => {
        const allCustomersUrl = '/customers/all';

        try {
            await fetch(allCustomersUrl, {
                method: 'GET',
                headers: {'Content-Type': 'application/json'}
            }).then(r => r.json()).then(result => setCustomersArr(result));
        } catch {
            console.warn('error loading customers')
        }
    }
    const [customersArr, setCustomersArr] = useState([]);

    return (
        <div className="App">
            <CustomerRequestForm  customers={customersArr} getCustomers={getCustomers}/>
            <br/><br/><br/>
            <CreateCustomer/><br/><br/>
            <CreateAccount/>
        </div>
    );

}

export default App;
