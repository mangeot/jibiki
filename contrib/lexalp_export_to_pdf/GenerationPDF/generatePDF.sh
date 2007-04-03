#! /bin/sh

# Variables d'environnement
JAVA=/System/Library/Frameworks/JavaVM.framework/Versions/1.4.2/Home/bin/java
SAXON=net.sf.saxon.Transform
SAXON_CP=/Library/Java/Extensions/saxonb8-7-3j/saxon8.jar

#For 0.20.5 
#FOP=org.apache.fop.apps.Fop
#FOP_CP=/Library/Java/Extensions/fop-0.20.5/build/fop.jar:/Library/Java/Extensions/fop-0.20.5/lib/batik.jar:/Library/Java/Extensions/xalan-j_2_4_1/bin/xalan.jar:/Library/Java/Extensions/xalan-j_2_4_1/bin/xercesImpl.jar:/Library/Java/Extensions/fop-0.20.5/lib/avalon-framework-cvs-20020806.jar:/Library/Java/Extensions/xalan-j_2_4_1/bin/xml-apis.jar
#FOP_CONF=fop-0.20.5-conf/userconfig.xml

#For 0.93
FOP=org.apache.fop.cli.Main
FOP_CP=/Library/Java/Extensions/fop-0.93/lib/xmlgraphics-commons-1.1.jar:/Library/Java/Extensions/fop-0.93/lib/xml-apis-1.3.02.jar:/Library/Java/Extensions/fop-0.93/lib/xercesImpl-2.7.1.jar:/Library/Java/Extensions/fop-0.93/lib/xalan-2.7.0.jar:/Library/Java/Extensions/fop-0.93/lib/serializer-2.7.0.jar:/Library/Java/Extensions/fop-0.93/lib/commons-logging-1.0.4.jar:/Library/Java/Extensions/fop-0.93/lib/commons-io-1.1.jar:/Library/Java/Extensions/fop-0.93/lib/batik-all-1.6.jar:/Library/Java/Extensions/fop-0.93/lib/avalon-framework-4.2.0.jar:/Library/Java/Extensions/fop-0.93/build/fop.jar:/Library/Java/Extensions/fop-0.93/build/fop-sandbox.jar:/Library/Java/Extensions/fop-0.93/build/fop-hyph.jar:/usr/local/antlr-2.7.4/antlr.jar
FOP_CONF=fop-0.93-conf/fop.xconf


# Liste des domaines pr�sents dans LexALP
DOMAIN[1]="CONSERVATION OF NATURE AND LANDSCAPE PROTECTION"
DOMAIN[11]="Conservation of nature"
DOMAIN[12]="Landscape protection"
DOMAIN[13]="Protected areas"
DOMAIN[14]="Protection of fauna and flora"

DOMAIN[15]="Environmental protection"
DOMAIN[150]="Environmental policy"
DOMAIN[151]="Soil protection"
DOMAIN[152]="Waste"
DOMAIN[153]="Pollution"

DOMAIN[16]="Water protection"
DOMAIN[17]="Environmental impact assessment"
DOMAIN[18]="Natural disasters"

DOMAIN[2]="TRANSPORT"
DOMAIN[20]="Transport policy"
DOMAIN[21]="Rail transport"
DOMAIN[22]="Road transport"
DOMAIN[23]="Air transport"
DOMAIN[24]="Sea transport"
DOMAIN[25]="Inland navigation"
DOMAIN[26]="Combined transport"
DOMAIN[27]="Passenger transport"
DOMAIN[28]="Transport of goods"
DOMAIN[29]="Transport networks"
DOMAIN[210]="Transport safety"
DOMAIN[211]="Contract of carriage"

DOMAIN[3]="REGIONAL ECONOMIC DEVELOPMENT"
DOMAIN[31]="Regional policy"
DOMAIN[32]="Industry"
DOMAIN[33]="Trade"
DOMAIN[34]="Handicraft"
DOMAIN[35]="Tourism"
DOMAIN[36]="Employment"
DOMAIN[37]="Co-operation"
DOMAIN[38]="Energy"

DOMAIN[4]="RURAL AREAS"
DOMAIN[41]="Agriculture"
DOMAIN[42]="Forests"
DOMAIN[43]="Zootechnics"
DOMAIN[44]="Hunting, fisheries and fish farming"
DOMAIN[45]="Natural hazards"

DOMAIN[5]="URBAN SPACE"
DOMAIN[51]="Town planning"
DOMAIN[52]="Urban areas"
DOMAIN[53]="Building"

DOMAIN[6]="GENERAL TERMS"


# Param�tres : 

## $1 : fichier, fusion des termes (utilis� pour la cr�ation de l'index)
echo 'Fichier contenant la fusion des termes seulement : ' $1

## $2 : fichier, fusion des axies et termes
echo 'Fichier contenant la fusion des axies et des termes : ' $2

## $3 : tout or specifique
echo 'Traitement : ' $3

## $4 : entier, [1..3] nombre de domaines utilis�s : 3 si domaine, domaine parent, domaine parent parent
echo 'Nombre de domaines : ' $4

### initialisation de variables bol�ennes de remplissage de l'index
NB_DOMAINS=$4
if [ "$NB_DOMAINS" == "3" ]; then
	SUP_SUP_TEST="true"
	SUP_TEST="true"
	TEST="true"
elif [ "$NB_DOMAINS" == "2" ]; then
	SUP_SUP_TEST="false"
	SUP_TEST="true"
	TEST="true"
elif [ "$NB_DOMAINS" == "1" ]; then
	SUP_SUP_TEST="false"
	SUP_TEST="false"
	TEST="true"
fi

## $4 : Num�ro de domaine
DOMAIN_NUMBER=$5
echo $DOMAIN_NUMBER > temp/domain_number.txt
DOMAIN_NAME=${DOMAIN[`sed 's/[.]//g' temp/domain_number.txt`]}
rm temp/domain_number.txt
echo 'Domain :' $DOMAIN_NUMBER $DOMAIN_NAME

## $5 : Num�ro de domaine parent
SUP_DOMAIN_NUMBER=$6
echo $SUP_DOMAIN_NUMBER > temp/sup_domain_number.txt
SUP_DOMAIN_NAME=${DOMAIN[`sed 's/[.]//g' temp/sup_domain_number.txt`]}
rm temp/sup_domain_number.txt
echo 'Domain parent :' $SUP_DOMAIN_NUMBER $SUP_DOMAIN_NAME

## $6 : Num�ro de domaine parent parent
SUP_SUP_DOMAIN_NUMBER=$7
echo $SUP_SUP_DOMAIN_NUMBER > temp/sup_sup_domain_number.txt
SUP_SUP_DOMAIN_NAME=${DOMAIN[`sed 's/[.]//g' temp/sup_sup_domain_number.txt`]}
rm temp/sup_sup_domain_number.txt
echo 'Domain parent/parent :' $SUP_SUP_DOMAIN_NUMBER $SUP_SUP_DOMAIN_NAME


# Variables

## Date
DATE=`date +%e-%m-%Y`
echo 'Date :' $DATE

## fichier temporaire
if [ "$NB_DOMAINS" == "3" ]; then
	TEMP="temp_"$SUP_SUP_DOMAIN_NUMBER
elif [ "$NB_DOMAINS" == "2" ]; then
	TEMP="temp_"$SUP_DOMAIN_NUMBER
fi
echo 'Fichier temporaire :' $TEMP

## fichier final
FINAL=$DOMAIN_NUMBER"_final"
echo 'Fichier final :' $FINAL

####################### Pr�paration des donn�es (G�n�ral au domaine parent)
# Programme

if [ "$3" == "tout" ]; then 
echo 'Preparation des donnees - General au domaine parent'

# 1/ Mettre le dernier auteur dans entry et axie
 sed -e 's/<d:modification>\([ ]*\)<d:author>\([^<]*\)<\/d:author>\(.*\)<entry /<d:modification>\1<d:author>\2<\/d:author>\3<entry author="\2" /' \
 	-e 's/<d:modification>\([ ]*\)<d:author>\([^<]*\)<\/d:author>\(.*\)<axie /<d:modification>\1<d:author>\2<\/d:author>\3<axie author="\2" /' $2 > temp/$TEMP.author
 
 ## 2/ Enlever les metadatas des contributions
 $JAVA -Xms128m -Xmx512m -cp $SAXON_CP $SAXON -o temp/$TEMP.sm temp/$TEMP.author XSL/3_sansMetadata.xsl
 
 ## 3/ Am�liorer les informations des 'related terms' contenus dans les termes
 ## 	  et ajouter des termes reli�s dans les axies
 $JAVA -Xms128m -Xmx512m -cp $SAXON_CP $SAXON -o temp/$TEMP.rta temp/$TEMP.sm XSL/4_relatedTermAxie.xsl
 
 ## 4/ Ajouter les axies reli�s dans les axies
 $JAVA -Xms128m -Xmx512m -cp $SAXON_CP $SAXON -o temp/$TEMP.rar temp/$TEMP.rta XSL/4_bis_relatedAxieRef.xsl
 
 ## 5/ Effacer les termes pr�sent � la fois dans la partie axie et dans la partie terme
 $JAVA -Xms128m -Xmx512m -cp $SAXON_CP $SAXON -o temp/$TEMP.et temp/$TEMP.rar XSL/5_effacerTermes.xsl

fi
 
####################### G�n�ration de l'index (sp�cifique au domaine)
#  

if [ "$3" == "specifique" ] || [ "$3" == "tout" ]; then 
echo 'Generation de l index - specifique au domaine'

 ## 6/ Remplir le template correspondant au XSL g�n�rant l'index
 sed -e "s/\&SUP_SUP_TEST/$SUP_SUP_TEST/g" \
 	-e "s/\&SUP_TEST/$SUP_TEST/g" \
 	-e "s/\&TEST/$TEST/g" \
 	-e "s/\&DOMAIN_NUMBER/$DOMAIN_NUMBER/g" \
 	-e "s/\&DOMAIN_NAME/$DOMAIN_NAME/g" \
 	-e "s/\&SUP_DOMAIN_NUMBER/$SUP_DOMAIN_NUMBER/g" \
 	-e "s/\&SUP_DOMAIN_NAME/$SUP_DOMAIN_NAME/g" \
 	-e "s/\&SUP_SUP_DOMAIN_NUMBER/$SUP_SUP_DOMAIN_NUMBER/g" \
 	-e "s/\&SUP_SUP_DOMAIN_NAME/$SUP_SUP_DOMAIN_NAME/g" XSL/1_bis_createIndex_template.xsl > temp/1_bis_createIndex.xsl
 
 ## 7/ Remplir le template correspondant au XSL g�n�rant le fo
 sed -e "s/\&DOMAIN_NUMBER/$DOMAIN_NUMBER/g" \
 	-e "s/\&DOMAIN_NAME/$DOMAIN_NAME/g" \
 	-e "s/\&DATE/$DATE/g" XSL/6_formatageFO_template.xsl > temp/6_formatageFO.xsl
 		
 ## 8/ G�n�rer l'index
 $JAVA -Xms128m -Xmx512m -cp $SAXON_CP $SAXON -o temp/index.fo $1 temp/1_bis_createIndex.xsl
 ### Effacer la ligne 1 de l'index g�n�r�
 tail -n +2 temp/index.fo > temp/index2.fo
 
 ## 9/ G�n�rer le fo sans index
 $JAVA -Xms128m -Xmx512m -cp $SAXON_CP $SAXON -o temp/$TEMP.fo temp/$TEMP.et temp/6_formatageFO.xsl

fi

####################### Fusion des donn�es et g�n�ration du pdf (Correction des doublons et reg�n�ration)
echo 'Fusion des donnees et generation du pdf'

## 10/ Fusionner le fo et l'index
awk '/\>Index\<\/fo\:block\>/{print $0; system("cat temp/index2.fo"); next};{print $0}' temp/$TEMP.fo > temp/$FINAL.fo

## 11/ g�n�rer le pdf final
# For 0.20.5 
#$JAVA -Xms128m -Xmx512m -cp $FOP_CP $FOP -c $FOP_CONF -fo $FINAL.fo -pdf $FINAL.pdf
# For 0.93
$JAVA -Xms128m -Xmx512m -cp $FOP_CP $FOP -c $FOP_CONF -fo temp/$FINAL.fo -pdf $FINAL.pdf




## 5_SPECIFIC/ garder les axies qui n'ont aucun terme allemand de IPrzysucha
#$JAVA -Xms128m -Xmx512m -cp $SAXON_CP $SAXON -o $TEMP.et $TEMP.rar XSL/Sp_Author.xsl

## 11_SPECIFIC garder les axies qui n'ont aucun terme allemand de IPrzysucha
#$JAVA -Xms128m -Xmx512m -cp $SAXON_CP $SAXON -o $FINAL.2.fo $FINAL.fo XSL/Sp_removeItaEngSlv.xsl
## enlever information a la main
#$JAVA -Xms128m -Xmx512m -cp $FOP_CP $FOP -fo $FINAL.2.fo -pdf $FINAL.pdf
	
	
## Ne garder que les axies avec un terme de IPrzysucha

#EXEMPLE d'utilisation
# ./generatePDF.sh fusionTermes.xml fusion.xml 2 1.3 1 




