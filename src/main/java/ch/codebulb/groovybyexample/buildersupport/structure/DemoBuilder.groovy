package ch.codebulb.groovybyexample.buildersupport.structure

class DemoBuilder extends BuilderSupport {
    @Override
    public void setParent(Object parent, Object child) {
        println "parent $parent << child $child"
    }
    
    @Override
    public Object createNode(Object name) {
       return createNode(name, null, null);
    }

    @Override
    public Object createNode(Object name, Object value) {
       return createNode(name, null, value);
    }

    @Override
    public Object createNode(Object name, Map attrs) {
       return createNode(name, attrs, null);
    }

    @Override
    public Object createNode(Object name, Map attrs, Object value) {
        println "* node $name with args $attrs and value $value."
        return name
    }
}
