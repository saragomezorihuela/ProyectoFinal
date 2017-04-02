package pe.edu.utp.dentalservice.service;

import pe.edu.utp.dentalservice.models.*;

import java.sql.Connection;
import java.util.List;

/*
 * Created by Rodrigo Rivas on 18/03/2017.
*/
public class DsService {

    private Connection connection;
    private PeoplesEntity peoplesEntity;
    private EmployeesEntity employeesEntity;
    private HospitalsEntity hospitalsEntity;
    private GendersEntity gendersEntity;
    private IdentityCardsEntity identityCardsEntity;
    private BloodTypesEntity bloodTypesEntity;
    private TreatmentTypesEntity treatmentTypesEntity;
    private StatesToothEntity statesToothEntity;
    private CountriesEntity countriesEntity;
    private ProfilesEntity profilesEntity;
    private TurnsEntity turnsEntity;
    private DepartmentsEntity departmentsEntity;
    private ProvincesEntity provincesEntity;
    private DoctorsEntity doctorsEntity;
    private PatientsEntity patientsEntity;
    private MedicalEspecialitiesEntity medicalEspecialitiesEntity;
    private SchedulesEntity schedulesEntity;
    private UsersEntity usersEntity;

    public DsService() {
    }

    public DsService(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected TreatmentTypesEntity getTreatmentTypesEntity() {
        if (connection != null) {
            if (treatmentTypesEntity == null) {
                treatmentTypesEntity = new TreatmentTypesEntity();
                treatmentTypesEntity.setConnection(getConnection());
            }
        }
        return treatmentTypesEntity;
    }

    protected void setTreatmentTypesEntity(TreatmentTypesEntity treatmentTypesEntity) {
        this.bloodTypesEntity = bloodTypesEntity;
    }

    protected void setStatesToothEntity(StatesToothEntity statesToothEntity) {
        this.statesToothEntity = statesToothEntity;
    }

    protected void setProfilesEntity(ProfilesEntity profilesEntity) {
        this.profilesEntity = profilesEntity;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // TURN
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setTurnsEntity(TurnsEntity turnsEntity) {
        this.turnsEntity = turnsEntity;
    }

    public List<Turn> findAllTurns() {
        return getTurnsEntity().findAll();
    }

    public int getTurnsCount() {
        return getTurnsEntity().getTurnsCount();
    }

    protected TurnsEntity getTurnsEntity() {
        if (connection != null) {
            if (turnsEntity == null) {
                turnsEntity = new TurnsEntity();
                turnsEntity.setConnection(getConnection());
            }
        }
        return turnsEntity;
    }

    public boolean addTurn(Turn turn) {
        return getTurnsEntity().create(turn);
    }

    public boolean updateTurn(Turn turn) {
        return getTurnsEntity().update(turn);
    }

    public boolean deleteTurn(Turn turn) {
        return getTurnsEntity().delete(turn.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // HOSPITALS
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setHospitalsEntity(HospitalsEntity hospitalsEntity) {
        this.hospitalsEntity = hospitalsEntity;
    }

    public List<Hospital> findAllHospitals() {
        return getHospitalsEntity().findAll();
    }

    public int getHospitalsCount() {
        return getHospitalsEntity().getHospitalsCount();
    }

    protected HospitalsEntity getHospitalsEntity() {
        if (connection != null) {
            if (hospitalsEntity == null) {
                hospitalsEntity = new HospitalsEntity();
                hospitalsEntity.setConnection(getConnection());
            }
        }
        return hospitalsEntity;
    }

    public boolean addHospital(Hospital hospital, People people,User user, IdentityCard identityCard, Gender gender) {

        boolean p,u;
        p = getPeoplesEntity().create(people, identityCard, gender, hospital);
        people.setId(getPeoplesEntity().getPeopleId());
        u = getUsersEntity().create(user,people,1);

        return getHospitalsEntity().create(hospital);
    }

    public boolean updateHospital(Hospital hospital) {
        return getHospitalsEntity().update(hospital);
    }

    public boolean deleteHospital(Hospital hospital) {
        return getHospitalsEntity().delete(hospital.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // IDENTITY CARD
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setIdentityCardsEntity(IdentityCardsEntity identityCardsEntity) {
        this.identityCardsEntity = identityCardsEntity;
    }

    public List<IdentityCard> findAllIdentityCards() {
        return getIdentityCardsEntity().findAll();
    }

    public int getIdentityCardsCount() {
        return getTurnsEntity().getTurnsCount();
    }

    protected IdentityCardsEntity getIdentityCardsEntity() {
        if (connection != null) {
            if (identityCardsEntity == null) {
                identityCardsEntity = new IdentityCardsEntity();
                identityCardsEntity.setConnection(getConnection());
            }
        }
        return identityCardsEntity;
    }

    public boolean addIdentityCard(IdentityCard identityCard) {
        return getIdentityCardsEntity().create(identityCard);
    }

    public boolean updateIdentityCard(IdentityCard identityCard) {
        return getIdentityCardsEntity().update(identityCard);
    }

    public boolean deleteIdentityCard(IdentityCard identityCard) {
        return getIdentityCardsEntity().delete(identityCard.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // GENDER
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setGendersEntity(GendersEntity gendersEntity) {
        this.gendersEntity = gendersEntity;
    }

    public List<Gender> findAllGenders() {
        return getGendersEntity().findAll();
    }

    public int getGendersCount() {
        return getGendersEntity().getGendersCount();
    }

    protected GendersEntity getGendersEntity() {
        if (connection != null) {
            if (gendersEntity == null) {
                gendersEntity = new GendersEntity();
                gendersEntity.setConnection(getConnection());
            }
        }
        return gendersEntity;
    }

    public boolean addGender(Gender gender) {
        return getGendersEntity().create(gender);
    }

    public boolean updateGender(Gender gender) {
        return getGendersEntity().update(gender);
    }

    public boolean deleteGender(Gender gender) {
        return getGendersEntity().delete(gender.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // DEPARTMENTS
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setDepartmentsEntity(DepartmentsEntity departmentsEntity) {
        this.departmentsEntity = departmentsEntity;
    }

    public List<Department> findAllDepartments() {
        return getDepartmentsEntity().findAll();
    }

    public int getDepartmentsCount() {
        return getDepartmentsEntity().getDepartmentsCount();
    }

    protected DepartmentsEntity getDepartmentsEntity() {
        if (connection != null) {
            if (departmentsEntity == null) {
                departmentsEntity = new DepartmentsEntity();
                departmentsEntity.setConnection(getConnection());
            }
        }
        return departmentsEntity;
    }

    public boolean addDepartment(Department department, Country country) {
        return getDepartmentsEntity().create(department, country);
    }

    public boolean updateDepartment(Department department) {
        return getDepartmentsEntity().update(department);
    }

    public boolean deleteDepartment(Department department) {
        return getDepartmentsEntity().delete(department.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // BLOOD TYPE
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setBloodTypesEntity(BloodTypesEntity bloodTypesEntity) {
        this.bloodTypesEntity = bloodTypesEntity;
    }

    public List<BloodType> findAllBloodTypes() {
        return getBloodTypesEntity().findAll();
    }

    public int getBloodTypesCount() {
        return getBloodTypesEntity().getBloodTypesCount();
    }

    protected BloodTypesEntity getBloodTypesEntity() {
        if (connection != null) {
            if (bloodTypesEntity == null) {
                bloodTypesEntity = new BloodTypesEntity();
                bloodTypesEntity.setConnection(getConnection());
            }
        }
        return bloodTypesEntity;
    }

    public boolean addBloodType(BloodType bloodType) {
        return getBloodTypesEntity().create(bloodType);
    }

    public boolean updateBloodType(BloodType bloodType) {
        return getBloodTypesEntity().update(bloodType);
    }

    public boolean deleteBloodType(BloodType bloodType) {
        return getBloodTypesEntity().delete(bloodType.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // PROVINCE
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setProvincesEntity(ProvincesEntity provincesEntity) {
        this.provincesEntity = provincesEntity;
    }

    public List<Province> findAllProvinces(int departmentId) {
        return getProvincesEntity().findAll(departmentId);
    }

    public int getProvincesCount() {
        return getProvincesEntity().getProvincesCount();
    }

    protected ProvincesEntity getProvincesEntity() {
        if (connection != null) {
            if (provincesEntity == null) {
                provincesEntity = new ProvincesEntity();
                provincesEntity.setConnection(getConnection());
            }
        }
        return provincesEntity;
    }

    public boolean addProvince(Province province) {
        return getProvincesEntity().create(province);
    }

    public boolean updateProvince(Province province) {
        return getProvincesEntity().update(province);
    }

    public boolean deleteProvince(Province province) {
        return getProvincesEntity().delete(province.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // DOCTOR
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setDoctorsEntity(DoctorsEntity doctorsEntity) {
        this.gendersEntity = gendersEntity;
    }

    public List<Doctor> findAllDoctors(String user) {

        Hospital hospital=new Hospital();
        hospital.setId(getPeoplesEntity().getIdHospital(user));

        return getDoctorsEntity().findAll(hospital);

    }

    public int getDoctorsCount() {
        return getDoctorsEntity().getDoctorsCount();
    }

    protected DoctorsEntity getDoctorsEntity() {
        if (connection != null) {
            if (doctorsEntity == null) {
                doctorsEntity = new DoctorsEntity();
                doctorsEntity.setConnection(getConnection());
            }
        }
        return doctorsEntity;
    }

    public boolean addDoctor(People people, Doctor doctor, IdentityCard identityCard, Gender gender,
                             MedicalEspeciality medicalEspeciality,Hospital hospital, String user) {

        hospital.setId(getPeoplesEntity().getIdHospital(user));

        boolean p;
        p = getPeoplesEntity().create(people, identityCard, gender, hospital);

        doctor.setId(getPeoplesEntity().getPeopleId());

        return getDoctorsEntity().create(doctor, medicalEspeciality);
    }

    public boolean updateDoctor(Doctor doctor) {
        return getDoctorsEntity().update(doctor);
    }

    public boolean deleteDoctor(Doctor doctor) {
        return getDoctorsEntity().delete(doctor.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // PATIENT
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setPatientsEntity(PatientsEntity patientsEntity) {
        this.patientsEntity = patientsEntity;
    }

    public List<Patient> findAllPatients(String user ) {

        Hospital hospital=new Hospital();
        hospital.setId(getPeoplesEntity().getIdHospital(user));

        return getPatientsEntity().findAll(hospital);
    }

    public List<Patient> findAllPatientsExt(People people) {
        return getPatientsEntity().findAllExt(people);
    }

    public int getPatientsCount() {
        return getPatientsEntity().getPatientsCount();
    }

    protected PatientsEntity getPatientsEntity() {
        if (connection != null) {
            if (patientsEntity == null) {
                patientsEntity = new PatientsEntity();
                patientsEntity.setConnection(getConnection());
            }
        }
        return patientsEntity;
    }

    public boolean addPatient(People people, Patient patient, IdentityCard identityCard, Gender gender,
                              Hospital hospital, String user) {

        User usuario = new User();

        hospital.setId(getPeoplesEntity().getIdHospital(user));

        boolean p,u;
        p = getPeoplesEntity().create(people, identityCard, gender, hospital);

        patient.setId(getPeoplesEntity().getPeopleId());
        /*creacion de usuario*/
        usuario.setName(people.getNroDocumento());
        usuario.setPassword(people.getNroDocumento());
        people.setId(getPeoplesEntity().getPeopleId());
        u = getUsersEntity().create(usuario,people,3);

        return getPatientsEntity().create(patient);

    }

    public boolean updatePatient(Patient patient) {
        return getPatientsEntity().update(patient);
    }

    public boolean deletePatient(Patient patient) {
        return getPatientsEntity().delete(patient.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // STATE TOOTH
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setStateTeethEntity(StatesToothEntity statesToothEntity) {
        this.statesToothEntity = statesToothEntity;
    }

    public List<StateTooth> findAllStateTeeth() {
        return getStatesToothEntity().findAll();
    }

    public int getStateTeethCount() {
        return getStatesToothEntity().getStateTeethCount();
    }

    protected StatesToothEntity getStatesToothEntity() {
        if (connection != null) {
            if (statesToothEntity == null) {
                statesToothEntity = new StatesToothEntity();
                statesToothEntity.setConnection(getConnection());
            }
        }
        return statesToothEntity;
    }

    public boolean addStateTooth(StateTooth stateTooth) {
        return getStatesToothEntity().create(stateTooth);
    }

    public boolean updateStateTooth(StateTooth stateTooth) {
        return getStatesToothEntity().update(stateTooth);
    }

    public boolean deleteStateTooth(StateTooth stateTooth) {
        return getStatesToothEntity().delete(stateTooth.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // TREATMENT TYPE
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setTreatmentTypeEntity(TreatmentTypesEntity treatmentTypesEntity) {
        this.treatmentTypesEntity = treatmentTypesEntity;
    }

    public List<TreatmentType> findAllTreatmentType() {
        return getTreatmentTypeEntity().findAll();
    }

    public int getTreatmentTypeCount() {
        return getTreatmentTypeEntity().getTreatmentTypesCount();
    }

    protected TreatmentTypesEntity getTreatmentTypeEntity() {
        if (connection != null) {
            if (treatmentTypesEntity == null) {
                treatmentTypesEntity = new TreatmentTypesEntity();
                treatmentTypesEntity.setConnection(getConnection());
            }
        }
        return treatmentTypesEntity;
    }

    public boolean addTreatmentType(TreatmentType treatmentType) {
        return getTreatmentTypesEntity().create(treatmentType);
    }

    public boolean updateTreatmentType(TreatmentType treatmentType) {
        return getTreatmentTypesEntity().update(treatmentType);
    }

    public boolean deleteTreatmentType(TreatmentType treatmentType) {
        return getTreatmentTypesEntity().delete(treatmentType.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // COUNTRY
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setCountriesEntity(CountriesEntity countriesEntity) {
        this.countriesEntity = countriesEntity;
    }

    public List<Country> findAllCountries() {
        return getCountriesEntity().findAll();
    }

    public int getCountriesCount() {
        return getCountriesEntity().getCountriesCount();
    }

    protected CountriesEntity getCountriesEntity() {
        if (connection != null) {
            if (countriesEntity == null) {
                countriesEntity = new CountriesEntity();
                countriesEntity.setConnection(getConnection());
            }
        }
        return countriesEntity;
    }

    public boolean addCountry(Country country) {
        return getCountriesEntity().create(country);
    }

    public boolean updateCountry(Country country) {
        return getCountriesEntity().update(country);
    }

    public boolean deleteCountry(Country country) {
        return getCountriesEntity().delete(country.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // MEDICAL ESPECIALITY
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setMedicalEspecialitiesEntity(MedicalEspecialitiesEntity medicalEspecialitiesEntity) {
        this.medicalEspecialitiesEntity = medicalEspecialitiesEntity;
    }

    public List<MedicalEspeciality> findAllMedicalEspecialities() {
        return getMedicalEspecialitiesEntity().findAll();
    }

    public int getMedicalEspecialitiesCount() {
        return getMedicalEspecialitiesEntity().getMedicalEspecialitiesCount();
    }

    protected MedicalEspecialitiesEntity getMedicalEspecialitiesEntity() {
        if (connection != null) {
            if (medicalEspecialitiesEntity == null) {
                medicalEspecialitiesEntity = new MedicalEspecialitiesEntity();
                medicalEspecialitiesEntity.setConnection(getConnection());
            }
        }
        return medicalEspecialitiesEntity;
    }

    public boolean addMedicalEspeciality(MedicalEspeciality medicalEspeciality) {
        return getMedicalEspecialitiesEntity().create(medicalEspeciality);
    }

    public boolean updateMedicalEspeciality(MedicalEspeciality medicalEspeciality) {
        return getMedicalEspecialitiesEntity().update(medicalEspeciality);
    }

    public boolean deleteMedicalEspeciality(MedicalEspeciality medicalEspeciality) {
        return getCountriesEntity().delete(medicalEspeciality.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // PEOPLE
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setPeoplesEntity(PeoplesEntity peoplesEntity) {
        this.peoplesEntity = peoplesEntity;
    }

    public List<People> findAllPeoples() {
        return getPeoplesEntity().findAll();
    }

    public People findPeople(String user) {
        return getPeoplesEntity().findPeople(user);
    }

    public int getPeoplesCount() {
        return getPeoplesEntity().getPeoplesCount();
    }

    protected PeoplesEntity getPeoplesEntity() {
        if (connection != null) {
            if (peoplesEntity == null) {
                peoplesEntity = new PeoplesEntity();
                peoplesEntity.setConnection(getConnection());
            }
        }
        return peoplesEntity;
    }

    public boolean addPeople(People people, Hospital hospital, BloodType bloodType, IdentityCard identityCard,
                             District district, Gender gender) {
        return getPeoplesEntity().create(people,identityCard,gender, hospital);
    }

    public boolean updatePeople(People people) {
        return getPeoplesEntity().update(people);
    }

    public boolean deletePeople(People people) {
        return getPeoplesEntity().delete(people.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SCHEDULE
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setSchedulesEntity(SchedulesEntity schedulesEntity) {
        this.schedulesEntity = schedulesEntity;
    }

    public List<Schedule> findAllSchedules() {
        return getSchedulesEntity().findAll();
    }

    public int getSchedulesCount() {
        return getSchedulesEntity().getSchedulesCount();
    }

    protected SchedulesEntity getSchedulesEntity() {
        if (connection != null) {
            if (schedulesEntity == null) {
                schedulesEntity = new SchedulesEntity();
                schedulesEntity.setConnection(getConnection());
            }
        }
        return schedulesEntity;
    }

    public boolean addSchedule(Schedule schedule, Turn turn) {
        return getSchedulesEntity().create(schedule,turn);
    }

    public boolean updateSchedule(Schedule schedule) {
        return getSchedulesEntity().update(schedule);
    }

    public boolean deleteSchedule(Schedule schedule) {
        return getSchedulesEntity().delete(schedule.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // EMPLOYEE
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setEmployeesEntity(EmployeesEntity employeesEntity) {
        this.employeesEntity = employeesEntity;
    }

    public List<Employee> findAllEmployees() {
        return getEmployeesEntity().findAll();
    }

    public int getEmployeesCount() {
        return getEmployeesEntity().getEmployeesCount();
    }

    protected EmployeesEntity getEmployeesEntity() {
        if (connection != null) {
            if (employeesEntity == null) {
                employeesEntity = new EmployeesEntity();
                employeesEntity.setConnection(getConnection());
            }
        }
        return employeesEntity;
    }

    public boolean addEmployee(People people, Employee employee, IdentityCard identityCard, Gender gender, Hospital hospital) {

        boolean p;
        p = getPeoplesEntity().create(people, identityCard, gender,hospital);

        employee.setId(getPeoplesEntity().getPeopleId());

        return getEmployeesEntity().create(employee);
    }

    public boolean updateEmployee(Employee employee) {
        return getEmployeesEntity().update(employee);
    }

    public boolean deleteEmployee(Employee employee) {
        return getEmployeesEntity().delete(employee.getId());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // USER
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    public List<User> findAllUsers() {
        return getUsersEntity().findAll();
    }

    protected UsersEntity getUsersEntity() {
        if (connection != null) {
            if (usersEntity == null) {
                usersEntity = new UsersEntity();
                usersEntity.setConnection(getConnection());
            }
        }
        return usersEntity;
    }

    public boolean addUsersEntity(User user, People people,int perfilId) {
        return getUsersEntity().create(user,people,perfilId);
    }

    public boolean updateUser(User user) {
        return getUsersEntity().update(user);
    }

    public boolean deleteUser(User user) {
        return getUsersEntity().delete(user.getId());
    }

    public int loginUser(User user) {
        return getUsersEntity().getLogin(user);
    }

    public int profileUser(User user) {
        return getUsersEntity().getIdProfile(user);
    }

    public String GetFullName(User user){
        return getPeoplesEntity().getPeopleName(user);
    }

    public String GetHospitalName(User user){
        return getHospitalsEntity().getHospitalName(user);
    }

}