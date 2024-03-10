import React, { useState } from 'react';
import { v4 as uuidv4 } from 'uuid';

const AddTaskForm = ({ onAddTask }) => {
  const [id, setId] = useState(uuidv4());       // Temporal UUID from client..
  
  // Estado para el nombre, descripción y a quien va asignada la tarea
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [assignee, setAssignee] = useState('');
  
  const handleAddTask = (add) => {
    let newTask = null;
    if (add) newTask = { id, name, description, assignee };
    onAddTask(newTask);
  };

  return (
    <div className="add-task-form">
      <input
        id="task-name"
        type="text"
        placeholder="Nombre de la tarea"
        value={name}
        onChange={e => setName(e.target.value)}
      />
      <textarea
        id="task-description"
        placeholder="Descripción de la tarea"
        value={description}
        onChange={e => setDescription(e.target.value)}
      />
      <input
        id="task-assigned"
        type="text"
        placeholder="Asignada a"
        value={assignee}
        onChange={e => setAssignee(e.target.value)}
      />
      <div className='actions'>
        <button onClick={() => handleAddTask(true)}>Agregar Tarea</button>
        <button style={{backgroundColor: "brown"}} onClick={() => handleAddTask(false)}>Cancelar</button>
      </div>
    </div>
  );
};

export default AddTaskForm;