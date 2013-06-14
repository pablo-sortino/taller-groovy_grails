package biblioteca

class Autor {

	String nombre
	String nacionalidad
	
	static hasMany = [libros:Libro]
	
    static constraints = {
		nombre()
		nacionalidad(inList:['argentina','estados unidos','francia'])
    }
}
