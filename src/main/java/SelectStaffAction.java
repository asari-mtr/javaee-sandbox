import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by asari on 2015/05/14.
 */
@Named
@SessionScoped
public class SelectStaffAction implements Serializable {
    private static final Collection<Staff> masterList = new ArrayList<Staff>();
    private String selectUnit;

    public String getSelectUnit() {
        return selectUnit;
    }

    public void setSelectUnit(String selectUnit) {
        System.out.println(selectUnit);

        this.selectUnit = selectUnit;
    }

    private Collection<String> unitList;
    private Collection<Staff> leftList;
    private Collection<Staff> rightList;
    private Collection<Staff> registerList;

static {
        masterList.add(new Staff("チームA","高橋みなみ"));
        masterList.add(new Staff("チームA","小嶋陽菜"));
        masterList.add(new Staff("チームA","島崎遥香"));
        masterList.add(new Staff("チームA","宮脇咲良"));
        masterList.add(new Staff("チームA","武藤十夢"));
        masterList.add(new Staff("チームB","柏木由紀"));
        masterList.add(new Staff("チームK","山本彩"));
        masterList.add(new Staff("チームK","島田晴香"));
        masterList.add(new Staff("チームB","倉持明日香"));
        masterList.add(new Staff("チームB","橋本耀"));
        masterList.add(new Staff("チームB","渡辺麻友"));
    }
    @PostConstruct
    public void init() {
        registerList = new LinkedHashSet<Staff>();
    }
    public Collection<String> getUnitList() {
        return masterList.stream().map(i -> i.getUnit()).distinct().collect(Collectors.toList());
    }

    public void setUnitList(Collection<String> unitList) {
        this.unitList = unitList;
    }

    public Collection<Staff> getLeftList() {
        List<Staff> collect = masterList.stream().filter(i -> i.getUnit().equals(selectUnit)).collect(Collectors.toList());
        for(Staff s : collect){
            System.out.println(s);
        }
        return collect;
    }

    public void setLeftList(Collection<Staff> leftList) {
        this.leftList = leftList;
    }

    public Collection<Staff> getRightList() {
        return registerList;
    }

    public void setRightList(Collection<Staff> rightList) {
        this.rightList = rightList;
    }
    public void addStaff() {
        registerList.addAll(leftList);
    }
    public void removeStaff() {
        registerList.removeAll(rightList);
    }

    public static class Staff implements Serializable{
        private String unit;
        private String name;

        public Staff(String unit, String name) {
            this.unit = unit;
            this.name = name;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Staff staff = (Staff) o;

            if (name != null ? !name.equals(staff.name) : staff.name != null) return false;
            if (unit != null ? !unit.equals(staff.unit) : staff.unit != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = unit != null ? unit.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "unit=" + unit+", name=" +name;
        }
    }
    @FacesConverter("staffConverter")
    public static class StaffConverter implements Converter {


        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
            return masterList.stream().filter(i -> i.getName().equals(s)).findFirst().get();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
            return masterList.stream().filter(i -> i.equals(o)).findFirst().get().getName();
        }
    }
}
