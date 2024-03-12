import { useContext, useState } from "react";
import { useDrop } from 'react-dnd';
import Task from "./Task";
import AddTaskForm from "./AddTaskForm";
import { TaskContext } from '../context/TaskContext'

const Column = ({ name, colTasks }) => {

   // Uso del contexto de tareas
  const { tasks, setTasks, setMutate } = useContext(TaskContext);

  // Estado para controlar la adición de tareas
  const [adding, setAdding] = useState(false);

  // Función para agregar una tarea o moficar su status al cambiar de columna
  const addTask = (item, newTask = null) => {

    if (tasks.some(task => task.id === item.id)) {
      if (item.status !== name) {
        setTasks(tasks.map(task => {
          if (task.id === item.id) {
            // Guarda en DB..
            setMutate({ action: 'PATCH', parms: { id: item.id, status: name } });

            return { ...task, status: name };
          }
          return task;
        }));
      }
    } else {
      setMutate({ action: 'POST', parms: { id: newTask.id, name: newTask.name, description: newTask.description, assignee: newTask.assignee, status: name } });
      setTasks([...tasks, newTask])
    }
  }

  // Lógica para el uso de react-dnd para arrastrar y soltar tareas
  const [{ canDrop, isOver }, drop] = useDrop({
    accept: 'TASK',
    drop: (item, monitor) => {  // Lógica para mover la tarea a la columna correspondiente
      addTask(item);
    },
    collect: monitor => ({
      isOver: monitor.isOver(),
      canDrop: monitor.canDrop(),
    }),
  });

  // Manejador para agregar una nueva tarea
  const handleAddTask = (newTask) => {
    if (newTask) {
      const item = { id: null };
      newTask.status = name;
      addTask(item, newTask);
    }

    setAdding(false)
  }

  // Manejador para agregar una nueva tarea
  return (
    <div className="column-container" id={name}>
      <h2 style={{textTransform: "capitalize"}}>{name === 'procesando' ? 'En Proceso' : name}</h2>
      <div ref={drop} className="column-tasks" id={name}>
        {colTasks.length ?
          colTasks.map((task, index) => (
            <Task key={task.id} index={index} task={task} />
          ))
        :
          <p><i>Sin tareas</i></p>
        }
        {adding ? // Formulario para agregar una nueva tarea o botón para mostrar el formulario
          <AddTaskForm onAddTask={handleAddTask} />
        :
          <button onClick={() => setAdding(true)} title="Nueva Tarea">+</button>
        }
      </div>
    </div>
  )
}

export default Column;