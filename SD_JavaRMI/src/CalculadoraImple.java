import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImple extends UnicastRemoteObject implements Calculadora{

	private static final long serialVersionUID = 816371916387479245L;

	protected CalculadoraImple() throws RemoteException{
		super();
	}

	public long add(long a, long b) throws RemoteException {
		return a+b;
	}
	
}
