<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Шаблон, который определяет корневой элемент трансформации -->
    <xsl:template match="/">
        <origins>
            <xsl:apply-templates select="//gem" />
        </origins>
    </xsl:template>

    <!-- Шаблон для обработки каждого `gem` элемента -->
    <xsl:template match="gem">
        <xsl:variable name="origin" select="origin" />
        <xsl:element name="origin">
            <xsl:attribute name="place">
                <xsl:value-of select="$origin" />
            </xsl:attribute>
            <gem>
                <name><xsl:value-of select="name" /></name>
                <preciousness><xsl:value-of select="preciousness" /></preciousness>
                <visualParameters>
                    <color><xsl:value-of select="visualParameters/color" /></color>
                    <transparency><xsl:value-of select="visualParameters/transparency" /></transparency>
                    <cut><xsl:value-of select="visualParameters/cut" /></cut>
                </visualParameters>
                <value><xsl:value-of select="value" /></value>
            </gem>
        </xsl:element>
    </xsl:template>

</xsl:stylesheet>