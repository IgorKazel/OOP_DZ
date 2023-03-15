public abstract class BaseItem implements Comparable<BaseItem> {
    public String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else if (this.getName().equals(((BaseItem) obj).getName())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(BaseItem obj){
        return this.name.compareTo(obj.getName());
    }
}
