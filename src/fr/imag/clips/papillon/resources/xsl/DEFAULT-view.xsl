<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<!DOCTYPE xsl:stylesheet [
	<!ENTITY nbsp " ">
]>
<xsl:stylesheet version="1.0"
	xmlns:d='http://www-clips.imag.fr/geta/services/dml' 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xlink="http://www.w3.org/1999/xlink"
	xmlns="http://www.w3.org/1999/xhtml"
	exclude-result-prefixes="d xlink xsi xsl">

<xsl:output method="html" encoding="utf-8" indent="yes"/> 

<!-- Copy through any element that doesn't have a template.-->
<!-- Include attributes and content. -->
<xsl:template match="*|@*" priority="-2">
<xsl:copy><xsl:apply-templates select="@*|*|text()"/></xsl:copy>
</xsl:template>

<xsl:template match="comment()">
  <xsl:comment><xsl:value-of select="."/></xsl:comment>
</xsl:template>

<!-- transform any dml element into a span -->

<xsl:template match="d:*" priority="-1">
<span>
<xsl:attribute name="class"><xsl:value-of select="local-name()" /></xsl:attribute>
  <xsl:apply-templates/>
</span>
</xsl:template>

<xsl:template match="d:examples">		
<blockquote>
<span class="examples"><xsl:apply-templates/></span>
</blockquote>
</xsl:template>

<xsl:template match="d:idioms">		
<blockquote>
<span class="idioms"><xsl:apply-templates/></span>
</blockquote>
</xsl:template>

<xsl:template match="d:reflexie">		
<a class="reflexie">
	<xsl:attribute name="href">
		<xsl:value-of select="@xlink:href"/>
	</xsl:attribute>
<xsl:apply-templates/>
</a>
</xsl:template>

<xsl:template match="d:pronunciation">
<xsl:if test="text()">		
<xsl:text>/</xsl:text>
<span class="pronunciation"><xsl:apply-templates/></span>
<xsl:text>/</xsl:text>
</xsl:if>
</xsl:template>

<xsl:template match="d:pos">
<xsl:if test="text()">		
<span class="pos"><xsl:apply-templates/></span>
</xsl:if>
</xsl:template>

<xsl:template match="d:headword">		
<xsl:if test="text()">
<span class="headword"><xsl:apply-templates/></span>
</xsl:if>
</xsl:template>

<xsl:template match="d:writing">		
<xsl:if test="text()">
<xsl:text>【</xsl:text>
<span class="writing"><xsl:apply-templates/></span>
<xsl:text>】</xsl:text>
</xsl:if>
</xsl:template>

<xsl:template match="d:reading">		
<xsl:if test="text()">
<span class="reading">[<xsl:apply-templates/>]</span>
</xsl:if>
</xsl:template>

<xsl:template match="d:translations">		
<blockquote><xsl:apply-templates/></blockquote>
</xsl:template>

<xsl:template match="d:sense">		
<blockquote>
<span class="sense"><xsl:apply-templates/></span>
</blockquote>
</xsl:template>

<xsl:template match="d:space">&nbsp;</xsl:template>

 <xsl:template name="alternated-row">
        <xsl:attribute name="class">
            <xsl:if test="position() mod 2 = 1">oddrow</xsl:if>
            <xsl:if test="position() mod 2 = 0">evenrow</xsl:if>
        </xsl:attribute>
</xsl:template>

</xsl:stylesheet> 
