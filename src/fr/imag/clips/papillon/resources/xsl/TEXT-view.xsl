<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet version="1.0"
	xmlns:d='http://www-clips.imag.fr/geta/services/dml' 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns="http://www.w3.org/1999/xhtml">

<xsl:output method="text" encoding="utf-8" indent="no"/> 

<!-- general templates please do not modify -->

<!-- here I do not use the xsl:copy because it copies also xmlns: attributes -->
<xsl:template match="*" priority="-1"><xsl:apply-templates /></xsl:template>

<xsl:template match="comment()"></xsl:template>


<xsl:template match="/"><xsl:apply-templates/></xsl:template>

<!-- volume specific templates -->

<xsl:template match="d:entry">
<xsl:apply-templates select="d:headword"/>
<xsl:apply-templates select="d:pronunciation"/>
<xsl:apply-templates select="d:pos"/>
</xsl:template>

<xsl:template match="d:headword">
<xsl:apply-templates />
</xsl:template>

<xsl:template match="d:pronunciation">
<xsl:if test="text()!=''"> /<xsl:apply-templates />/</xsl:if>
</xsl:template>

<xsl:template match="d:pos">
<xsl:if test="text()!=''">, <xsl:apply-templates /></xsl:if>
</xsl:template>

<xsl:template match="d:mot">
  <d:headword>
	<xsl:apply-templates/>
  </d:headword>
</xsl:template>

<xsl:template match="d:type">
  <d:space/>
	<xsl:apply-templates/>
</xsl:template>

<xsl:template match="d:particule">
   <xsl:if test="text()!=''">
      <xsl:apply-templates/><d:space/>
    </xsl:if>
</xsl:template>

<xsl:template match="d:flexion">
  <xsl:text>[</xsl:text>
	<xsl:apply-templates/>
  <xsl:text>]</xsl:text>
</xsl:template>

<xsl:template match="d:formes-de-base">
	<xsl:apply-templates/>
</xsl:template>

<xsl:template match="d:inf-da">
	<xsl:apply-templates/>
</xsl:template>

<xsl:template match="d:pres-indicatif">
	<xsl:apply-templates/>
</xsl:template>

<xsl:template match="d:bloc-gram">
  <d:sense>
	<xsl:apply-templates/>
  </d:sense>
</xsl:template>

<xsl:template match="d:cat-gram">
  <d:pos>
	<xsl:apply-templates/>
  </d:pos>
</xsl:template>

<xsl:template match="d:bloc-semantique">
  <d:sense>
	<xsl:apply-templates select="d:registre-sens-vedette"/>
	<xsl:apply-templates select="d:indication-sem1"/>
	<xsl:apply-templates select="d:sous-bloc-semantique"/>
	<xsl:apply-templates select="d:bloc-exemples"/>
  </d:sense>
</xsl:template>

<xsl:template match="registre-sens-vedette">
   <xsl:if test="text()!=''">
		<xsl:apply-templates/>
   </xsl:if>
</xsl:template>

<xsl:template match="d:indication-sem1">
   <xsl:if test="text()!=''">
  		<d:label>
			<xsl:apply-templates/>
  		</d:label>
   </xsl:if>
</xsl:template>

<xsl:template match="d:sous-bloc-semantique">
  <d:sense>
	<xsl:apply-templates select="d:indication-sem2"/>
	<xsl:apply-templates select="d:bloc-contextuel"/>
  </d:sense>
</xsl:template>

<xsl:template match="d:indication-sem2">
	<xsl:if test="text()!=''">
		<d:label>
			<xsl:apply-templates/>
		</d:label>
	</xsl:if>
</xsl:template>

<xsl:template match="d:bloc-contextuel">
  <d:sense>
	<xsl:apply-templates/>
  </d:sense>
</xsl:template>

<xsl:template match="d:indication-cont">
  <d:label>
	<xsl:apply-templates/>
  </d:label>
</xsl:template>

<xsl:template match="d:bloc-equivalent">
  <d:sense>
	<xsl:apply-templates/>
  </d:sense>
</xsl:template>

<xsl:template match="d:avant">
  <d:fra>
	<xsl:apply-templates/>
  </d:fra>
</xsl:template>

<xsl:template match="d:mot-princ">
  <d:fra>
  <d:translation>
	<xsl:apply-templates/>
  </d:translation>
  </d:fra>
</xsl:template>

<xsl:template match="d:apres">
  <d:fra>
	<xsl:apply-templates/>
  </d:fra>
</xsl:template>

<xsl:template match="d:registre-equiv">
  <d:fra>
	<xsl:apply-templates/>
  </d:fra>
</xsl:template>

<xsl:template match="d:rection-est">
  <d:est>
	<xsl:apply-templates/>
  </d:est>
</xsl:template>

<xsl:template match="d:rection-fra">
  <d:fra>
	<xsl:apply-templates/>
  </d:fra>
</xsl:template>

<xsl:template match="d:bloc-exemples">
  <d:exemples><xsl:text>Exemples :</xsl:text><d:space/>
	<xsl:apply-templates/>
  </d:exemples>
</xsl:template>

<xsl:template match="d:exemple">
	<xsl:apply-templates/>
</xsl:template>

<xsl:template match="d:exemple-est">
 <d:est>
  <d:example>
	<xsl:apply-templates/>
  </d:example>
  </d:est>
</xsl:template>

<xsl:template match="d:traduction-exe">
 <d:fra>
  <d:example>
	<xsl:apply-templates/>
  </d:example>
  </d:fra>
</xsl:template>

<xsl:template match="d:bloc-phraseol">
  <d:idioms><xsl:text>Phraséologie :</xsl:text><d:space/>
	<xsl:apply-templates/>
  </d:idioms>
</xsl:template>

<xsl:template match="d:unite-phraseol">
	<xsl:apply-templates/>
</xsl:template>

<xsl:template match="d:expression-est">
 <xsl:if test="text()!=''">
 <d:est>
  <d:idiom>
	<xsl:apply-templates/>
  </d:idiom>
  </d:est>
  <br />
  </xsl:if>
</xsl:template>

<xsl:template match="d:expression-fra">
 <xsl:if test="text()!=''">
 <d:fra>
  <d:idiom>
	<xsl:apply-templates/>
  </d:idiom>
  </d:fra>
  <br />
  </xsl:if>
</xsl:template>

<xsl:template match="d:traduction-expr">
 <xsl:if test="text()!=''">
 <d:fra>
  <d:idiom>
	<xsl:apply-templates/>
  </d:idiom>
  </d:fra>
  <br />
  </xsl:if>
</xsl:template>

<xsl:template match="d:bloc-renvois">
  <d:sense><xsl:text>Renvois :</xsl:text><d:space/>
  	<xsl:for-each select="d:renvoi-phraseol">
	<a>
	<xsl:attribute name="href">
    	<xsl:value-of select="text()"/>
  	</xsl:attribute> 
	<xsl:apply-templates/>
	</a>
   <xsl:if test="position()!=last()">
      <xsl:text>,</xsl:text><d:space/>
    </xsl:if>
	</xsl:for-each>
  </d:sense>
</xsl:template>

<xsl:template match="d:renvoi-phraseol">
	<a>
	<xsl:attribute name="href">
    	<xsl:value-of select="text()"/>
  	</xsl:attribute> 
	<xsl:apply-templates/>
	</a>
   <xsl:if test="position()!=last()">
      <xsl:text>,</xsl:text><d:space/>
    </xsl:if>
</xsl:template>



</xsl:stylesheet>
