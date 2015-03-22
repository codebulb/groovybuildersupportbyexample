package ch.codebulb.groovybyexample.buildersupport.structure

class HouseholdBuilderPlus extends HouseholdBuilder {
    public static List build(Closure closure) {
        return new HouseholdBuilderPlus().invokeMethod("build", closure)
    }
    
    public livingRoom(String roomName="living room", Closure closure) {
        room {
            name(roomName)
            furniture(name: "TV", price: 2000)
            furniture(name: "sofa", price: 1000)
            closure?.call()
        }
    }
    
    public String propertyMissing(String name) {
        // replace camelCase with "whitespace separated"
        name.replaceAll (/[A-Z](?=[a-z])/) {" ${it.toLowerCase()}"}
    }
}
