package ch.codebulb.groovybyexample.buildersupport.structure

class DemoBuilderPlus extends DemoBuilder {
    public Object car(String name, int price) {
       return createNode("car", [name: name, price: price]);
    }
}
