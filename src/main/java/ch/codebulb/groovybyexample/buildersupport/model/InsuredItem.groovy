package ch.codebulb.groovybyexample.buildersupport.model

import groovy.transform.*

@TupleConstructor
@EqualsAndHashCode
class InsuredItem {
    String name
    int price
}
