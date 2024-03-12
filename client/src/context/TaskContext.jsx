import { createContext, useState, useEffect } from "react";

// Crea un contexto de tareas
export const TaskContext = createContext();

// Crea un proveedor de contexto para las tareas
export function TaskContextProvider(props) {
  
  // Define estados para tareas, mutaciones y columnas
  const [tasks, setTasks] = useState([]);
  const [mutate, setMutate] = useState(null);

  const API_URL = "http://localhost:8080/api/v1/tasks";

  const [columns, setColumns] = useState([
    {
      id: 1, name: 'pendiente'
    },
    {
      id: 2, name: 'procesando'
    },
    {
      id: 3, name: 'finalizado'
    }
  ]);

  // Maneja la eliminación de tareas
  const handleRemoveTask = (task) => {
    if (confirm("Borrar Tarea?"))  {
      setMutate({ action: 'DELETE', parms: { id: task.id } });
      setTasks(tasks.filter(t => t.id !== task.id));
    }
  }

  // Función para obtener todas las tareas
  function _fetchAll(populate = false) {
    fetch(API_URL)
    //fetch(API_URL, { referrerPolicy: "unsafe_url" })
      .then(response => response.json())
        .then(data => populate ? setTasks(data) : console.log(data));    
  }

  // Obtener todas las tareas al cargar
  useEffect(() => {
    _fetchAll(true);
  }, []);

  // Efecto para realizar mutaciones en las tareas
  useEffect(() => {
    if (mutate) {
      console.log('Mutating..', mutate)

      const url = API_URL + (mutate.action !== 'POST' ? `/${mutate.parms.id}` : '')
      console.log(url)
      
      fetch(url, {
        method: mutate.action,
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(mutate.parms),
      })
        .then(response => mutate.action !== 'DELETE' ? response.json() : response.text())
          .then(data => { 
            console.log(data);
            if (mutate.action === 'POST') {         // Create a new Task
              setTasks(tasks.map(task => {
                if (task.id === mutate.parms.id) {
                  return { ...task, id: data.id };  // Retrieve a valid UUID from server for security reasons..
                }
                return task;
              }));
            }
          });
      setMutate(null);
    }        
  }, [tasks]);

  // Retorna el proveedor de contexto con los valores y funciones necesarios
  return (
    <TaskContext.Provider
      value={{
        tasks, setTasks,
        columns, setColumns,
        setMutate,
        handleRemoveTask
      }}
    >
      {props.children}
    </TaskContext.Provider>
  );
}