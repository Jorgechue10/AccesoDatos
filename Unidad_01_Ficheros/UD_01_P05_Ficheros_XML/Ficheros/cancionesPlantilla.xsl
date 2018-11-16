<?xml version="1.0" encoding='UTF-8'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match='/'>
   <html><xsl:apply-templates /></html>
 </xsl:template>
 <xsl:template match='Canciones'>
    <head><title>LISTADO DE CANCIONES</title></head>
    <body> 
    <h1>LISTA DE CANCIONES</h1>
    <table border='1'>
    <tr><th>ID</th><th>AÑO</th><th>TITULO</th><th>ARTISTA</th><th>DURACIÓN</th><th>¿ESPAÑOLA?</th></tr>
      <xsl:apply-templates select='cancion' />
    </table>
    </body>
 </xsl:template>
 <xsl:template match='cancion'>
   <tr><xsl:apply-templates /></tr>
 </xsl:template>
 <xsl:template match='id|anio|titulo|artista|duracion|espaniola'>
   <td><xsl:apply-templates /></td>
 </xsl:template>
</xsl:stylesheet>