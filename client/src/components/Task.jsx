import { useContext, useEffect, useRef, useState } from 'react';
import { useDrag } from 'react-dnd';
import { TaskContext } from '../context/TaskContext'

// Definición del componente Task
const Task = ({ index, task }) => {

  // Uso del contexto TaskContext
  const { tasks, setTasks, setMutate, handleRemoveTask } = useContext(TaskContext);

  // Estado para el modo de edición
  const [editing, setEditing] = useState(false);
  const nameRef = useRef(null);
  const assigneeRef = useRef(null);
  const descriptionRef = useRef(null);

  // Lógica para el arrastre de tareas
  const [{ isDragging }, drag] = useDrag({
    type: 'TASK',
    item: { id: task.id, index, name: task.name, description: task.description, assignee: task.assignee, status: task.status },
    collect: monitor => ({
      isDragging: !!monitor.isDragging(),
    }),
  });

  // Función para manejar la edición de la tarea
  const handleEditTask = () => {
    setEditing(true);
    nameRef.current.focus();
  }

  // Efecto para enfocar en el nombre al editar
  useEffect(() => {
    if (editing) {
      nameRef.current.focus();
    }
  }, [editing]);

  // Función para manejar el cambio en la tarea
  const handleInputChange = () => {
    const name = nameRef.current.innerText;
    const description = descriptionRef.current.innerText;
    const assignee = assigneeRef.current.innerText;
    setEditing(false);
    
    // Actualización de la tarea si hay cambios
    if (name !== task.name || description !== task.description || assignee !== task.assignee) {
      setTasks(tasks.map(t => {
          if (t.id === task.id) {
            // Guarda en DB..
            setMutate({ action: 'PATCH', parms: { id: task.id, name, description, assignee } });
            return { ...t, name, description, assignee };
          }
          return t;
      }))
    }
  }

  // Función para cancelar la edición
  const handleCancelEdit = () => {
    setEditing(false);
    // Clear the fields..
    if (nameRef.current) nameRef.current.innerText = task.name;
    if (assigneeRef.current) assigneeRef.current.innerText = task.assignee;
    if (descriptionRef.current) descriptionRef.current.innerText = task.description;
  }

  // Renderizado del componente Task
  return (
    <div ref={drag} className={`task ${task.status}`}>
      <span className='close-btn' onClick={() => handleRemoveTask(task)}>x</span>
      {editing ?
        <div className='actions'>
          <span className='edit-btn' onClick={handleInputChange}>💾</span>
          <span className='edit-btn' onClick={handleCancelEdit}>↩️</span>
        </div>
        : <span className='edit-btn' onClick={handleEditTask}>✏️</span>
      }
      <b><p 
        ref={nameRef} 
        suppressContentEditableWarning={true} 
        contentEditable={editing} 
        id='description' 
        style={{marginTop: "22px"}}
        dangerouslySetInnerHTML={{ __html: task.name }}
      /></b>
      <i><p 
        ref={descriptionRef} 
        suppressContentEditableWarning={true} 
        contentEditable={editing} 
        id='description' 
        dangerouslySetInnerHTML={{ __html: task.description }}
      /></i>
      <span><u>Asignado a:</u> </span>
      <span
        ref={assigneeRef}
        suppressContentEditableWarning={true} 
        contentEditable={editing} 
        id='assignee' 
        dangerouslySetInnerHTML={{ __html: task.assignee }}
      />.<br></br><br></br>
    </div>
  );
};

export default Task;