package pe.edu.utp.dentalservice.beans;

import pe.edu.utp.dentalservice.models.Department;
import pe.edu.utp.dentalservice.models.Province;
import pe.edu.utp.dentalservice.service.DsService;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.FacesEvent;
import javax.faces.event.AjaxBehaviorEvent;

/**
 * Created by JUAN CARLOS on 23/03/2017.
 */
@ManagedBean(name = "ubigeoBean", eager = true)
@ViewScoped
public class DsUbigeoBean {
    private int selectDepartment; //+setters, getters
    private int selectProvince; //+setters, getters
    private String selectRegion; //+setters, getters
    private String selectStation; //+setters, getters
    private List<Department> availableDepartments; //+setters, getters
    private List<Province> availableProvinces; //+setters, getters

    /*
    private String selectedState; // getter+setter
    private String selectedCity; // getter+setter
    private String selectedRegion; // getter+setter
    private String selectedStation; // getter+setter
    private List<SelectItem> availableStates; // getter (no setter necessary!)
    private List<SelectItem> availableCities; // getter (no setter necessary!)
    private List<SelectItem> availableRegions; // getter (no setter necessary!)
    private List<SelectItem> availableStations; // getter (no setter necessary!)
*/
    //@EJB
    private DsService dsService;

    //@PostConstruct
    public void init() {
        availableDepartments = dsService.findAllDepartments();
    }

    public void changeState(AjaxBehaviorEvent event) {
        availableProvinces = dsService.findAllProvinces(selectDepartment);
        /*
        selectedCity = selectedRegion = selectedStation = null;
        availableRegions = availableStations = null;
        */
    }
/*
    public void changeCity(AjaxBehaviorEvent event) {
        availableRegions = someService.listRegions(selectedCity);
        selectedRegion = selectedStation = null;
        availableStations = null;
    }

    public void changeRegion(AjaxBehaviorEvent event) {
        availableStations = someService.listStations(selectedRegion);
        selectedStation = null;
    }
*/
/*
    public getRegionList(){
        RegionList= new ArrayList<SelectItem>();
        if(selectCity.equals("B")){
            RegionList.add(new SelectItem("C"));
        }
    }

    public getStationList(){
        StationList= new ArrayList<SelectItem>();
        if(selectRegion.equals("C")){
            StationList.add(new SelectItem("D"));
        }
    }
    */
}
