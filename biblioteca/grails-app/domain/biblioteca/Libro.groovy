package biblioteca

class Libro {

	String titulo
	String genero
	Date fechaPublicacion

	static belongTo = [autor:Autor]
	
    static constraints = {
		titulo(blank:false)
		genero(inList:['aventura', 'ciencia ficcion', 'infantiles', 'programacion'])
		fechaPublicacion(nullable: true)
    }
	
	String toString() {
		"$id - $titulo".toString()
	}
}
