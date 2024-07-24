<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xsd="Words.xsd"
                version="1.0">
    <xsl:template match="/">
        <xsd:words>
            <xsl:for-each select="xsd:words/xsd:word">
                <xsl:sort select="xsd:value"/>
                <xsd:word>
                    <xsl:choose>
                        <xsl:when test="string-length(xsd:value) &gt; 4">
                            <xsd:id>
                                <xsl:value-of select="xsd:id"/>
                            </xsd:id>
                            <xsd:value>
                                <xsl:value-of select="xsd:value"/>
                            </xsd:value>
                            <xsd:translation>
                                <xsl:value-of select="xsd:translation"/>
                            </xsd:translation>
                            <xsd:dictionary-type>
                                <xsl:value-of select="xsd:dictionary-type"/>
                            </xsd:dictionary-type>
                            <xsd:creation-date>
                                <xsl:value-of select="xsd:creation-date"/>
                            </xsd:creation-date>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsd:id>
                                <xsl:value-of select="xsd:id"/>
                            </xsd:id>
                            <xsd:value>
                                <xsl:value-of select="xsd:translation"/>
                            </xsd:value>
                            <xsd:translation>
                                <xsl:value-of select="xsd:value"/>
                            </xsd:translation>
                            <xsd:dictionary-type>
                                <xsl:value-of select="xsd:dictionary-type"/>
                            </xsd:dictionary-type>
                            <xsd:creation-date>
                                <xsl:value-of select="xsd:creation-date"/>
                            </xsd:creation-date>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsd:word>
            </xsl:for-each>
        </xsd:words>
    </xsl:template>
</xsl:stylesheet>