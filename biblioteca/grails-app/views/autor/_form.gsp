<%@ page import="biblioteca.Autor" %>



<div class="fieldcontain ${hasErrors(bean: autorInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="autor.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${autorInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: autorInstance, field: 'nacionalidad', 'error')} ">
	<label for="nacionalidad">
		<g:message code="autor.nacionalidad.label" default="Nacionalidad" />
		
	</label>
	<g:select name="nacionalidad" from="${autorInstance.constraints.nacionalidad.inList}" value="${autorInstance?.nacionalidad}" valueMessagePrefix="autor.nacionalidad" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: autorInstance, field: 'libros', 'error')} ">
	<label for="libros">
		<g:message code="autor.libros.label" default="Libros" />
		
	</label>
	<g:select name="libros" from="${biblioteca.Libro.list()}" multiple="multiple" optionKey="id" size="5" value="${autorInstance?.libros*.id}" class="many-to-many"/>
</div>

