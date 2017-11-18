<?xml version="1.0" ?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4"
					page-height="27cm" page-width="21cm" margin-top="1.5cm"
					margin-bottom="1.5cm" margin-left="1.5cm" margin-right="1.5cm">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4">
				<fo:flow flow-name="xsl-region-body">
					<xsl:for-each select="Collection/Recipe">
					<fo:block font-size="14pt">
					<xsl:value-of select="Title"></xsl:value-of>
					</fo:block>
					</xsl:for-each>
				</fo:flow>
			</fo:page-sequence>

		</fo:root>
		
	
	</xsl:template>
	<!--  
	<xsl:template match="Recipe">
		<xsl:text>&#xa;</xsl:text>
		<html>
			<body>
				<h2>My Collection</h2>
				<li>
					<xsl:value-of select="Title" />
				</li>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="/Collection">
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="Collection/Recipe">
		<xsl:number count="Recipe" level="single" format="1" />
		<xsl:text> </xsl:text>
		<xsl:value-of select="Title" />
		<xsl:apply-templates select="Ingredients" />
	</xsl:template>
	<xsl:template match="Ingredients">
		<xsl:for-each select="Ingredient">
			<xsl:number count="Recipe|Ingredient" level="multiple"
				format="1.1" />
			<xsl:text> </xsl:text>
			<xsl:value-of select="Name" />
		</xsl:for-each>
	</xsl:template>
	 -->
</xsl:stylesheet>