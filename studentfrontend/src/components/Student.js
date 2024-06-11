import React, { useEffect, useState } from 'react';
import './Student.css';
import logo from './refreshButton.jpg';

const Student = () => {
  const [name, setName] = useState('');
  const [address, setAddress] = useState('');
  const [students,setStudents] = useState([]);

  const handleSubmit = (e) => {
    e.preventDefault();

    // Check if name is empty
    if (!name.trim()) {
      alert("Name cannot be empty");
      return;
    }

    console.log(`Name: ${name}, Address: ${address}`);
    const student = { name, address }; // Create an object with the student data

    fetch("http://localhost:8080/student/add",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(student)
    }).then(()=>{
      console.log("New student added")
    })
  };

  useEffect(()=>{
    fetch("http://localhost:8080/student/getAll")
    .then(res=>res.json())
    .then((result)=>{
      setStudents(result)
    })
  },[])

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div className='formContainer'>
          <h1><u>Add Student</u></h1>
          <div>
            <label className='labelText'>Name:</label>
            <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
          </div>
          <br/>
          <div>
            <label className='labelText'>Address:</label>
            <input type="text" value={address} onChange={(e) => setAddress(e.target.value)} />
          </div>
          <br/>
          <button type="submit" className='submitButton'>Submit</button>
        </div>
      </form>
      <br/>
      <div className='formContainer'>
        <div className='studentList'> 
          <center><button className="imgButton" onClick={()=>window.location.reload()}><img className="logo" src={logo} alt="logo" /></button></center>
          <h2>Student List</h2>
          <ul>
            {students.map(student => (
              <li key={student.id}>{student.name} - {student.address}</li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Student;
