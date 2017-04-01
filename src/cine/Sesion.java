package cine;

public class Sesion {
	private String hora;
	// hora de la sesi�n en formato HH:MM
	private int asientosDisponibles;
	//es una matriz de enteros con las mismas dimensiones que la sala asociada a la propia sesi�n, en la que se representan las butacas compradas y las disponibles para la propia sesi�n. 
	//Si una butaca en la posici�n (i, j) est� disponible, se guarda un valor 0, y en caso contrario, se guarda el identificador de venta asociado a la butaca. Como en una venta se puede comprar m�s de una butaca, 
	//podr�a suceder que en la matriz haya varios identificadores de ventas iguales en posiciones contiguas. 
	private int sigIdCompra;
	//es un entero que indica el n�mero de asientos disponibles en la propia sesi�n
	private int [][] estadoAsientos;
	//es un entero que se incrementa cada vez que se realiza una venta de entradas para la propia sesi�n. Se utiliza para generar identificadores de venta diferentes para cada compra. 
	
	public Sesion (String hora, int fila, int columnas){
	//constructor de la clase Sesion que recibe como argumentos la hora de proyecci�n, y el n�mero de filas y columnas de la sala asociada a la propia sesi�n. Con estos argumentos, 
	//inicializa los atributos del objeto. El atributo sigIdComprase inicializa a 1. 
		this.hora = hora;
	}
	
	public String getHora(){
		//m�todo que devuelve la hora asociada a la propia sesi�n
		return this.hora;
	}
	
	public boolean equals(Sesion obj){
		//m�todo que compara el objeto de tipo Sesion dado con la propia sesi�n, y devuelve cierto si son iguales y falso en caso contrario. Se considera que dos sesiones son iguales si son iguales sus atributos hora.  
		if(this.hora.equals(obj.getHora())){
			return true;
		}else{
			return false;
		}
	}
	
	public void comprarEntrada(int fila, int columna){
	//m�todo que compra una entrada con la fila y columna dadas para la propia sesi�n. Para registrar la venta, se guarda el valor actual del atributo sigIdCompra en la posici�n 
	//(fila-1, columna-1) del atributo estadoAsientos. A continuaci�n, se incrementa en uno el atributo sigIdCompra.
		this.estadoAsientos[fila - 1][columna - 1]= sigIdCompra;
		sigIdCompra += 1;
	}
	
	public int getIdEntrada(int fila, int columna){
	// m�todo que devuelve el identificador de venta para una entrada en la propia sesi�n especificada mediante su fila y columna. El identificador que se devuelve se toma de la posici�n 
	//(fila-1, columna-1) del atributo estadoAsientos
		return this.estadoAsientos[fila - 1][columna - 1];
	}
	
	public char [][] getEstadoSesion(){
	//m�todo que devuelve una matriz de caracteres en la que se representa el estado de ocupaci�n de la propia sesi�n. La matriz resultado tiene el mismo n�mero de filas y columnas que la sala asociada
	//a la propia sesi�n, y en cada posici�n (i, j) de la matriz debe aparecer un car�cter �#� si la butaca ha sido comprada, y un car�cter �O� (O may�scula) si la butaca est� disponible. En la figura 2 se puede 
	//observar un ejemplo de una matriz de caracteres que refleja el estado de ocupaci�n de una sala en una sesi�n
		char res [][] = new char[this.estadoAsientos.length][this.estadoAsientos[0].length];
		for(int i= 0; i<this.estadoAsientos.length; i++){
			for (int j = 0; j< this.estadoAsientos[i].length;j++){
				if(this.estadoAsientos[i][j] > 0){
					res[i][j] = '#';
				}else{
					res[i][j] = 'O';
				}
			}
		}
		return res;
	}
	
	public int getButacasDisponiblesSesion(){
	//m�todo que devuelve el n�mero de butacas disponibles en la propia sesi�n.
		int res = 0;
		char estadoSesion [][] = getEstadoSesion();
		for(int i= 0; i<this.estadoAsientos.length; i++){
			for (int j = 0; j< this.estadoAsientos[i].length;j++){
				if(estadoSesion[i][j] == '#'){
					res += 1;
				}
			}
		}
		return res;
	}
	
	public String recogerEntradas(int id){
	//m�todo que devuelve las N entradas asociadas a un identificador de venta dado para la propia sesi�n. Las N entradas se devolver�n dentro de un String con el siguiente formato: 
	//�hora_de_la_sesi�n+fila1,columna1+fila2,columna2+ � +filaN,columnaN+� Si el identificador de venta dado no existe en la propia sesi�n, se devuelve null.
		String res = this.getHora();
	}
	
	public recomendarButacasContiguas(){
	// m�todo que dados un n�mero N de butacas, devuelve un objeto de tipo ButacasContiguas que contiene la fila y la columna de la butaca recomendaba con menor n�mero de columna, y el n�mero de butacas solicitadas. 
	//El algoritmo para obtener las butacas recomendadas es el siguiente: 1. Se buscan las primeras N butacas contiguas libres empezando por la fila (N_FILAS+1)/2+1 y acabando en la fila N_FILAS. Cada fila se recorre 
	//empezando por la columna N_COLUMNAS y acabando en la columna 1. 2. Si en el paso anterior no se encuentran N butacas contiguas libres, se buscan las primeras N butacas contiguas libres empezando por la fila 
	//(N_FILAS+1)/2 y acabando en la fila 1. Cada fila se recorre empezando por la columna N_COLUMNAS y acabando en la columna 1. Si no existen N butacas libres contiguas en la sala para la propia sesi�n, se devuelve null.
	//Por ejemplo, si tomamos la sala de la figura 2 y buscamos 3 butacas contiguas libres, este algoritmo devolver� las butacas (4, 3), (4, 4) y (4, 5). 
	}
	
	public void comprarEntradasRecomendadas(ButacasContiguas butacas){
	//m�todo que dado un objeto de tipo ButacasContiguas, registra la compra en la propia sesi�n guardando el valor actual del atributo sigIdCompra en las posiciones especificadas por el objeto dado como argumento. 
	//A continuaci�n, se incrementa en uno el atributo sigIdCompra. 
	}
	
	
}
