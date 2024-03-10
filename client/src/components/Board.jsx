import { useContext } from 'react';
import { TaskContext } from '../context/TaskContext'
import Column from './Column';

// Define el componente de tablero
const Board = () => {

  // Obtiene el contexto de tareas
  const { tasks, columns, setColumns } = useContext(TaskContext);
  
  // Renderiza las columnas con las tareas correspondientes
  return (
    <div className="board">
      {columns.map((column, index) => (
          <Column key={index} name={column.name} colTasks={tasks.filter(task => task.status === column.name)} />
      ))}
    </div>
  );
};

export default Board;