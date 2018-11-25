<?xml version="1.0" encoding='UTF-8'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match='/'>
   <html><xsl:apply-templates /></html>
 </xsl:template>
 <xsl:template match='listaCanciones'>
    <head><title>LISTADO DE CANCIONES</title></head>
    <body> 
    <h1>LISTA DE CANCIONES</h1>
    <table border='1'>
    <tr><th>ID</th><th>ANIO</th><th>TITULO</th><th>ARTISTA</th><th>DURACION</th><th>CANCION ESPANIOLA</th></tr>
      <xsl:apply-templates select='cancion' />
    </table>
    </body>
 </xsl:template>
 <xsl:template match='cancion'>
   <tr><xsl:apply-templates /></tr>
 </xsl:template>
 <xsl:template match='id|anio|titulo|artista|duracion|cancion_espaniola'>
   <td><xsl:apply-templates /></td>
 </xsl:template>
</xsl:stylesheet>