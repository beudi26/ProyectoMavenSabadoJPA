package TestEntidades;

import java.util.List;

import Dao.ClassClienteImp;
import model.TblCliente;

public class TestEntidadCliente {

	public static void main(String[] args) {
		//realizamos la respectiva instancia de las clases...
		TblCliente cliente = new TblCliente();
        ClassClienteImp crud = new ClassClienteImp();
		/*
		//asignamos valores
		cliente.setNombre("nilson ronaldo");
		cliente.setApellido("ramirez ramirez");
		cliente.setDni("1045789");
		cliente.setEmail("nilson@gmail.com");
		cliente.setTelf("3871459");
		cliente.setSexo("M");
		cliente.setNacionalidad("argentina");
		//invocamos al metodo registrar...
		crud.RegistrarCliente(cliente);*/
		
		//invocamos el metodo listado de clientes
		// Invocamos el método para obtener el listado de clientes
        List<TblCliente> listadoCliente = crud.ListadoCliente();


		// Iteramos sobre la lista de clientes y los imprimimos por pantalla
        for (TblCliente c : listadoCliente) {
            System.out.println("Código: " + c.getIdcliente() +
                               ", Nombre: " + c.getNombre() +
                               ", Apellido: " + c.getApellido() +
                               ", DNI: " + c.getDni() +
                               ", Email: " + c.getEmail());
        }


	}   //fin del metodo main...

} //fin de la clase...
