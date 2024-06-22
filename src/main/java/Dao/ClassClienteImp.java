package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.ICliente;
import model.TblCliente;

public class ClassClienteImp  implements ICliente  {

	@Override
	public void RegistrarCliente(TblCliente cliente) {
		//establecer conexion con la unidad de persistencia...
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
	    //permite gestionar entidades
		EntityManager em=fabr.createEntityManager();
		//iniciar transaccion
		em.getTransaction().begin();
		//registramos
		em.persist(cliente);
		//emitimos mensaje por consola
		System.out.println("cliente registrado en la BD correctamente");
		//confirmamos
		em.getTransaction().commit();
		//cerramos la transaccion
		em.close();
	}  //fin del metodo registrar...

	@Override
	public void ActualizarCliente(TblCliente cliente) {
	// establecer la conexion con la unidad de persistencia......
		
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
	//gestionar las entidades
		EntityManager emanager=em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		//actualizar
		emanager.merge(cliente);
		//emitimos mensaje por consola
		System.out.println("Cliente Actualizado en BD");
		//comfirmamos
	emanager.getTransaction().commit();
		//Cerramos
		emanager.close();
		//fin del metodo Actualizar cliente
		
	}   //fin del metodo actualizar cliente..

	@Override
	public void EliminarCliente(TblCliente cliente) {
		// establecer la conexion con la unidad de persistencia......
		
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
	//gestionar las entidades
		EntityManager emanager=em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		//recuperamos el codigo a eliminar
		TblCliente elim=emanager.merge(cliente);
		//Procedemos a eliminar
		emanager.remove(elim);
		//emitimos mensaje por consola
		System.out.println("Cliente eliminado en BD");
		//comfirmamos
	emanager.getTransaction().commit();
		//Cerramos
		emanager.close();
		//fin del metodo eliminar cliente
		
	}   //fin del metodo eliminar cliente...

	@Override
	public TblCliente BuscarCliente(TblCliente cliente) {
		// establecer la conexion con la unidad de persistencia......
				EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
					//gestionar las entidades
						EntityManager emanager=em.createEntityManager();
						//iniciamos la transaccion
						emanager.getTransaction().begin();
						//recuperamos el codigo buscar
						TblCliente buscarcli=emanager.find(TblCliente.class,cliente.getIdcliente());
						
				  //comfirmamos
					emanager.getTransaction().commit();
						//Cerramos
						emanager.close();
						//retornamaos el cliente de la BD
		return buscarcli;
	}  //fin del metodo buscar cliente...

	@Override
	public List<TblCliente> ListadoCliente() {
		// Establecer la conexión con la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");

		// Gestionar las entidades
		EntityManager em = emf.createEntityManager();

		// Iniciar la transacción
		em.getTransaction().begin();

		// Recuperar el listado de clientes desde la base de datos usando JPQL
		List<TblCliente> listado = em.createQuery("SELECT c FROM TblCliente c", TblCliente.class).getResultList();

		// Confirmar la transacción
		em.getTransaction().commit();

		// Cerrar el EntityManager
		em.close();

		// Retornar el listado de clientes obtenido de la BD
		return listado;

//fin del metodo listado cliente....
		
		
	}   //fin del metodo listado cliente.. 

}
