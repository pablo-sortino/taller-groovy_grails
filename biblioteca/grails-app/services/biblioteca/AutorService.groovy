package biblioteca

class AutorService {

	/*
	 * Retorna un mapa con los datos del autor.
	 */
    def obtenerAutor(autorId) {
		if (!autorId.isLong()) {
			//el id del autor tiene que ser numerico
			return null
		}
		def autor = Autor.get(autorId)
		autor ? ([id:autor.id, nombre:autor.nombre, nacionalidad:autor.nacionalidad]) : null 
    }
	
	
}
