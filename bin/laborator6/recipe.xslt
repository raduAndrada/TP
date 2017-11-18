<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/" >
   <xsl:for-each select="Collection/Recipe">
   <xsl:apply-templates select="."/>
 </xsl:for-each>
</xsl:template>
<xsl:template match="Recipe">
 <xsl:text>&#xa;</xsl:text>
  <html>
 <body>
    <h2>My Collection</h2>
    <li> <xsl:value-of select="Title"/></li>
 </body>
  </html>
</xsl:template>
<xsl:template match="/Collection">
  <xsl:apply-templates/>
</xsl:template>
<xsl:template match="Collection/Recipe">
  <xsl:number count="Recipe" level="single" format="1"/>
  <xsl:text> </xsl:text>
  <xsl:value-of select="Title"/>
  <xsl:apply-templates select="Ingredients"/>
</xsl:template>
<xsl:template match="Ingredients">
  <xsl:for-each select="Ingredient">
    <xsl:number count="Recipe|Ingredient" level="multiple" format="1.1"/>
    <xsl:text> </xsl:text>
    <xsl:value-of select="Name"/>
  </xsl:for-each>
</xsl:template>
</xsl:stylesheet>