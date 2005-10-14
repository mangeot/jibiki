<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<!--
 *  © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 *  Projet Papillon
 *
 *  $Id$
 *  $Log$
 *  Revision 1.4  2005/10/14 19:02:17  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.3  2005/05/24 12:51:22  serasset
 *  Updated many aspect of the Papillon project to handle lexalp project.
 *  1. Layout is now parametrable in the application configuration file.
 *  2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 *  3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 *  4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 *  5. It is now possible to give a name to the cookie key in the app conf file
 *  6. Several bug fixes.
 *
 *  Revision 1.2  2005/01/15 17:43:19  mangeot
 *  Added cvs Id and Log on the files
 *
-->
<!DOCTYPE xsl:stylesheet [
	<!ENTITY nbsp "  ">
]>
<xsl:stylesheet  version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html" 
	encoding="UTF-8"
	standalone="yes"
	indent="no"
	/>

<!--

  Feuille de style pour transformer les documents
xml en html avec des couleurs

For HTML spaces, I did not find a good solution.
I can't use the feature disable-output-escaping="yes"
so I cheated and added a dummy css style all white for the <span class="space"> class

I would like to find a solution in genreal for HTML entities...

-->

<!-- root element -->
<xsl:template match="/">	
<div><xsl:apply-templates/></div>
</xsl:template>



<!-- comments -->
<xsl:template match="comment()">
<br /><br />
<span class="xmlcomment">&lt;!-- <xsl:value-of select="normalize-space()" /> --&gt;</span>
</xsl:template>


<!-- elements -->
<xsl:template match="*" >
<br /><xsl:for-each select="ancestor::*">&nbsp;</xsl:for-each>

<span class="xmlcar">&lt;</span>

<xsl:if test="substring-before(name(),concat(':',local-name()))!=''">
<span class="xmlnsprefix"><xsl:value-of select="substring-before(name(),concat(':',local-name()))"/>
</span>	
<xsl:if test="substring-before(name(),concat(':',local-name()))!=''">
<span class="xmlcar">:</span>
</xsl:if>
</xsl:if>
<span class="xmlelement"><xsl:value-of select="local-name()"/></span>


<xsl:if test="count(ancestor::*)=0"><xsl:call-template name="namespaces"/></xsl:if>

<xsl:apply-templates select="@*"/>
<xsl:if test="*|text()">
<span class="xmlcar">&gt;</span>
</xsl:if>
<xsl:if test="not(*|text())">
<span class="xmlcar">/&gt;</span>
</xsl:if>

<xsl:apply-templates select="*|text()|comment()" />

<xsl:if test="*|text()">
<xsl:if test="*">
<br/>
<xsl:for-each select="ancestor::*">&nbsp;</xsl:for-each>
</xsl:if>
<span class="xmlcar">&lt;/</span>
<xsl:if test="substring-before(name(),concat(':',local-name()))!=''">
<span class="xmlnsprefix"><xsl:value-of select="substring-before(name(),concat(':',local-name()))"/>
</span>	
<xsl:if test="substring-before(name(),concat(':',local-name()))!=''">
<span class="xmlcar">:</span>
</xsl:if>
</xsl:if>
<span class="xmlelement"><xsl:value-of select="local-name()"/></span>
<span class="xmlcar">&gt;</span>
</xsl:if>
</xsl:template>

<!-- attributes -->
<xsl:template match="@*" >
&nbsp;
<!-- xmlnsprefix -->
<span class="xmlnsprefix">
	<xsl:value-of select="substring-before(name(),concat(':',local-name()))"/>
</span>
<!--les : eventuels -->			
<xsl:if test="substring-before(name(),concat(':',local-name()))!=''">
	<span class="xmlcar">:</span>
</xsl:if>
<span class="xmlattribute">
	<xsl:value-of select="local-name(current())"/>
	<span class="xmlcar">="</span>
	<span class="xmlvalue">
		<xsl:value-of select="current()"/>
	</span>
	<span class="xmlcar">"</span>
</span>
</xsl:template>

<!-- text -->
<xsl:template match="text()" >
	<xsl:if test="normalize-space()!=''">
		<span class="xmltext"><xsl:value-of  select="normalize-space()" /></span>
	</xsl:if>
	<xsl:apply-templates />
</xsl:template>

<!-- namespaces for the root element -->
<xsl:template name="namespaces" >
	<xsl:for-each select="namespace::*">
<br />&nbsp;
			<xsl:choose>		
			<xsl:when test="name()=''">
				<span class="xmlnsprefix">xmlns</span>
				<span class="xmlcar">="</span>
				<span class="xmlnsuri">
					<xsl:value-of select="current()"/>
				</span>
				<span class="xmlcar">"</span>
			</xsl:when>			
			<xsl:otherwise>
				<span class="xmlnsprefix">xmlns</span>
				<span class="xmlcar">:</span>
				<span class="xmlnsprefix">
					<xsl:value-of select="name()"/>						
				</span>
				<span class="xmlcar">="</span>					
				<span class="xmlnsuri">
					<xsl:value-of select="current()"/>
				</span>
				<span class="xmlcar">"</span>					
			</xsl:otherwise>				
	</xsl:choose>		
	</xsl:for-each>
</xsl:template>

</xsl:stylesheet>
