package View;
// MAIN

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Containers.LandlordRepository;
import Containers.LeaseRepository;
import Containers.PropertyRepository;
import Containers.TenantRepository;
import Entity.Landlord;
import Entity.Property;
import Entity.Tenant;
import Enum.EnumPropertyException;
import Enum.PropertyOccupation;
import Enum.PropertyType;
import Exceptions.LandlordException;
import Exceptions.LeaseException;
import Exceptions.PropertyException;
import Exceptions.TenantException;
import Services.LandlordService;
import Services.LeaseService;
import Services.PropertyService;
import Services.TenantService;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // News Repositorys
    private static PropertyRepository propertyRepository = new PropertyRepository();
    private static TenantRepository tenantRepository = new TenantRepository(new ArrayList<>());
    private static LandlordRepository landlordRepository = new LandlordRepository();
    private static LeaseRepository leaseRepository = new LeaseRepository();

    // News Service
    private static PropertyService propertyService = new PropertyService(propertyRepository);
    private static TenantService tenantService = new TenantService(tenantRepository);
    private static LandlordService landlordService = new LandlordService(landlordRepository);
    private static LeaseService leaseService = new LeaseService(leaseRepository);

    // CONTAINERS

    public static void main(String[] args)
            throws TenantException, LandlordException, PropertyException, LeaseException, ParseException {
        // OPÇÕES DO MENU
        boolean exit = false;
        do {
            menuMain();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    menuTenant();
                    break;
                case 2:
                    menuLandlord();
                    break;
                case 3:
                    menuProperty();
                    break;
                case 4:
                    menuLease();
                    break;
                case 5:
                    removeSomething();
                    break;
                case 0:
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    // METODOS PERSONALIZADOS

    // MENU
    private static void menuMain() {
        System.out.println("--------------------------------");
        System.out.println("SELECIONE SUA OPÇÃO: ");
        System.out.println("| 1.Para Acessar Inquilinos.");
        System.out.println("| 2.Para Acessar Proprietários.");
        System.out.println("| 3.Para Acessar Imoveis.");
        System.out.println("| 4.Para Acessar Contratos.");
        System.out.println("| 5.Para Remover Algo.");
        System.out.println("--------------------------------");
        System.out.println("| 0.Para Sair do Menu.");
        System.out.println("--------------------------------");
        System.out.print("\nOpção: ");
    }

    private static void menuTenant() throws TenantException {
        boolean exit = false;
        do {
            System.out.println("\nSELECIONE UMA OPÇÃO: ");
            System.out.println("| 0.Nenhum.");
            System.out.println("| 1.Para Cadastrar Inquilinos.");
            System.out.println("| 2.Para Checar Inquilinos.");
            System.out.println("| 3.Para Editar Inquilinos.");
            System.out.println("| 4.Para Pagar Imovel.");
            System.out.print("\nOpção: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    createTenants();
                    break;
                case 2:
                    tenantService.listTenant();
                    break;
                case 3:
                    changeTenants();
                    break;
                case 4:
                    System.out.println("Falta fazer ainda!");
                    break;
                case 5:
                    searchTenant();
                    break;
                case 0:
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    private static void menuLandlord() throws LandlordException {
        boolean exit = false;
        do {
            System.out.println("\nSELECIONE UMA OPÇÃO: ");
            System.out.println("| 0.Nenhum.");
            System.out.println("| 1.Para Cadastrar Proprietários.");
            System.out.println("| 2.Para Checar Proprietários.");
            System.out.println("| 3.Para Editar Proprietários.");
            System.out.print("\nOpção: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    createLandlord();
                    break;
                case 2:
                    landlordService.listLandlord();
                    break;
                case 3:
                    changeLandlord();
                    break;
                case 4:
                    searchLandlord();
                    break;
                case 0:
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    private static void menuProperty() throws PropertyException, LandlordException {
        boolean exit = false;
        do {
            System.out.println("\nSELECIONE UMA OPÇÃO: ");
            System.out.println("| 0.Nenhum.");
            System.out.println("| 1.Para Cadastrar Imoveis aos Proprietários.");
            System.out.println("| 2.Para Checar Imoveis.");
            System.out.println("| 3.Para Editar Imoveis.");
            System.out.println("| 4.Para adicionar lista de imoveis pronta.");
            System.out.print("\nOpção: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    createProperty();
                    break;
                case 2:
                    propertyService.listProperty();
                    break;
                case 3:
                    changeProperty();
                    break;
                case 4:
                    listProperties();
                    propertyService.listProperty();
                    break;
                case 5:
                    searchProperty();
                    break;
                case 0:
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    private static void menuLease() throws LeaseException, ParseException {
        boolean exit = false;
        do {
            System.out.println("\nSELECIONE UMA OPÇÃO: ");
            System.out.println("| 0.Nenhum.");
            System.out.println("| 1.Para Criar Contratos.");
            System.out.println("| 2.Para Checar Contratos.");
            System.out.println("| 3.Para Editar Contratos.");
            System.out.print("\nOpção: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    createLease();
                    break;
                case 2:
                    leaseService.listLease();
                    break;
                case 3:
                    changeLease();
                    break;
                case 4:
                    searchLease();
                    break;
                case 0:
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    // CRIAR INQUILINOS
    private static void createTenants() throws TenantException {
        try {
            System.out.print("\nNome: ");
            String name = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Telefone: ");
            String telephone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Saldo: ");
            double balance = scanner.nextDouble();
            tenantService.addTenant(name, cpf, telephone, email, balance);
        } catch (TenantException e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    // EDITAR INQUILINOS
    private static void changeTenants() throws TenantException {
        System.out.print("\nInsira o índice do Inquilino à editar: ");
        int id = scanner.nextInt();
        tenantService.changeTenant(id);
    }

    // CRIAR IMOVEIS
    private static void createProperty() {
        try {
            System.out.print("\nInsira o índice do Proprietario: ");
            int idLandlord = scanner.nextInt();
            Landlord landlord = landlordRepository.searchLandlord(idLandlord);
            scanner.nextLine();
            if (landlord != null) {
                System.out.print("\nEndereço: ");
                String address = scanner.nextLine();
                System.out.print("Valor do Aluguel: ");
                double rentalValue = scanner.nextDouble();
                System.out.print("Tipo: \n1.Residencial | 2.Comercial |");
                System.out.print("\nOpção: ");
                int type = scanner.nextInt();
                System.out.print("Ocupação: \n1.Desocupado | 2.Ocupado |");
                System.out.print("\nOpção: ");
                int occupation = scanner.nextInt();

                PropertyType propertyType = null;
                switch (type) {
                    case 1:
                        propertyType = PropertyType.RESIDENTIAL;
                        break;
                    case 2:
                        propertyType = PropertyType.COMMERCIAL;
                        break;
                    default:
                        throw new PropertyException("Erro: " + EnumPropertyException.PropertyInvalidType);
                }

                PropertyOccupation propertyOccupation = null;
                switch (occupation) {
                    case 1:
                        propertyOccupation = PropertyOccupation.UNOCCUPIED;
                        break;
                    case 2:
                        propertyOccupation = PropertyOccupation.OCCUPIED;
                        break;
                    default:
                        throw new PropertyException("Erro: " + EnumPropertyException.PropertyInvalidOccupation);
                }
                Property property = new Property(address, rentalValue, propertyType, propertyOccupation);
                propertyService.addProperty(landlord, property.getaddress(), property.getRentalValue(),
                        property.getType(), property.getOccupation());
                leaseService.assignPropertyToLandlord(landlord, property);
            } else {
                System.out.println("\nErro: Proprietário não foi cadastrado!");
            }

        } catch (PropertyException e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    // EDITAR IMOVEIS
    private static void changeProperty() throws PropertyException {
        System.out.print("\nInsira o índice do Imovel à editar: ");
        int id = scanner.nextInt();
        propertyService.changeProperty(id);
    }

    // CRIAR PROPRIETARIO
    private static void createLandlord() {
        try {
            System.out.print("\nNome: ");
            String name = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Telefone: ");
            String telephone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            landlordService.addLandlord(name, cpf, telephone, email);
        } catch (LandlordException e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    // EDITAR PROPRIETARIO
    private static void changeLandlord() throws LandlordException {
        System.out.print("\nInsira o índice do Proprietário à editar: ");
        int id = scanner.nextInt();
        landlordService.changeLandlord(id);
    }

    // CADASTRA INQUILINO NO IMOVEL (Criar o contrato)
    private static void createLease() throws LeaseException, ParseException {
        System.out.print("\nInsira o índice do Inquilino: ");
        int idTenant = scanner.nextInt();
        System.out.print("\nInsira o índice do Imovel: ");
        int idProperty = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nData de Inicio (DD/MM/AA): ");
        String startDate = scanner.nextLine();
        System.out.print("\nData de Fim (DD/MM/AA): ");
        String endDate = scanner.nextLine();

        Tenant tenant = tenantRepository.searchTenant(idTenant);
        Property property = propertyRepository.searchProperty(idProperty);
        if (tenant != null && property != null) {
            leaseService.addLease(startDate, endDate, property.getLandlord(), property, tenant);
        }
    }

    // LISTA CONTRATOS
    private static void changeLease() {
    }

    // DELETAR CONTRATOS
    
    //coloquei como comentário por que não está sendo usado ainda (aparentemente).

    /* 
    private static void deleteLease() {
    }
    */

    public static void removeSomething() {
        boolean exit = false;
        do {
            System.out.println("\n DESEJA REMOVER QUAL OPÇÃO: ");
            System.out.println("(O Contrato será excluido junto com a opção escolhida!)");
            System.out.println("| 0.Nenhum.");
            System.out.println("| 1.Inquilinos.");
            System.out.println("| 2.Proprietários.");
            System.out.println("| 3.Imovel do Proprietário.");
            System.out.print("\nOpção: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    removeTenants();
                    break;
                case 2:
                    removeLandlord();
                    break;
                case 3:
                    removePropertyLandlord();
                    break;
                case 0:
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    // REMOVER INQUILINOS
    private static void removeTenants() {
        tenantService.removeTenant();
    }

    // REMOVE IMOVEL DO PROPRIETARIO
    private static void removePropertyLandlord() {
        System.out.print("\nInsira o índice do Imovel para remover: ");
        int id = scanner.nextInt();
        propertyService.removeProperty(id);
    }

    // REMOVE PROPRIETARIO
    private static void removeLandlord() {
        System.out.print("\nInsira o índice do Proprietário à editar: ");
        int id = scanner.nextInt();
        landlordService.removeLandlord(id);
    }

    // BUSCA
    private static void searchTenant() {
        System.out.print("\nInsira o índice do Inquilino: ");
        int idTenant = scanner.nextInt();
        tenantService.searchTenant(idTenant);
    }

    private static void searchProperty() {
        System.out.print("\nInsira o índice do Imovel: ");
        int idProperty = scanner.nextInt();
        propertyService.searchProperty(idProperty);
    }

    private static void searchLandlord() {
        System.out.print("\nInsira o índice do Proprietario: ");
        int idLandlord = scanner.nextInt();
        landlordService.searchLandlord(idLandlord);
    }

    private static void searchLease() {
        System.out.print("\nInsira o índice do Contrato: ");
        int idLease = scanner.nextInt();
        leaseService.searchLease(idLease);
    }

    // LISTA DE IMOVEIS
    private static void listProperties() throws PropertyException, LandlordException {
        // LANDLORD ADD
        Landlord landlord01 = new Landlord("Liang", "74678506039", "86986012358", "Liang@gmail.com.br");
        Landlord landlord02 = new Landlord("Ravi", "89867001826", "62989335737", "Ravi@gmail.com.br");
        Landlord landlord03 = new Landlord("Elli", "21422187926", "63998845787", "Elli@gmail.com.br");
        Landlord landlord04 = new Landlord("Norabel", "38766718686", "92999042606", "Norabel@gmail.com.br");
        Landlord landlord05 = new Landlord("YuYan", "94614156487", "62991046653", "YuYan@gmail.com.br");

        // PROPERTY ADD
        Property property01 = new Property("Rua Gonçalo de Carvalho (RS)", 1000,
                PropertyType.RESIDENTIAL, PropertyOccupation.OCCUPIED);
        Property property02 = new Property("Rua do Mucugê (BA)", 1200, PropertyType.COMMERCIAL,
                PropertyOccupation.UNOCCUPIED);
        Property property03 = new Property("Rua das Pedras (RJ)", 1600,
                PropertyType.RESIDENTIAL,
                PropertyOccupation.UNOCCUPIED);
        Property property04 = new Property("Rua da Aurora (PE)", 1800,
                PropertyType.COMMERCIAL,
                PropertyOccupation.UNOCCUPIED);
        Property property05 = new Property("Rua Bento Gonçalves (RS)",
                2000, PropertyType.RESIDENTIAL,
                PropertyOccupation.UNOCCUPIED);

        // LANDLORD SERVICE
        landlordService.addLandlord(landlord01.getName(), landlord01.getCpf(), landlord01.getTelephone(),
                landlord01.getEmail());
        landlordService.addLandlord(landlord02.getName(), landlord02.getCpf(), landlord02.getTelephone(),
                landlord02.getEmail());
        landlordService.addLandlord(landlord03.getName(), landlord03.getCpf(), landlord03.getTelephone(),
                landlord03.getEmail());
        landlordService.addLandlord(landlord04.getName(), landlord04.getCpf(), landlord04.getTelephone(),
                landlord04.getEmail());
        landlordService.addLandlord(landlord05.getName(), landlord05.getCpf(), landlord05.getTelephone(),
                landlord05.getEmail());

        // PROPERTY SERVICE
        propertyService.addProperty(landlord01, property01.getaddress(), property01.getRentalValue(),
                property01.getType(), property01.getOccupation());
        propertyService.addProperty(landlord02, property02.getaddress(), property02.getRentalValue(),
                property02.getType(), property02.getOccupation());
        propertyService.addProperty(landlord03, property03.getaddress(), property03.getRentalValue(),
                property03.getType(), property03.getOccupation());
        propertyService.addProperty(landlord04, property04.getaddress(), property04.getRentalValue(),
                property04.getType(), property04.getOccupation());
        propertyService.addProperty(landlord05, property05.getaddress(), property05.getRentalValue(),
                property05.getType(), property05.getOccupation());

        // LANDLORD AND PROPERTY
        leaseService.assignPropertyToLandlord(landlord01, property01);
        leaseService.assignPropertyToLandlord(landlord02, property02);
        leaseService.assignPropertyToLandlord(landlord03, property03);
        leaseService.assignPropertyToLandlord(landlord04, property04);
        leaseService.assignPropertyToLandlord(landlord05, property05);
    }

}
