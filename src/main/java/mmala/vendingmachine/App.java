
package mmala.vendingmachine;

import mmala.vendingmachine.controller.VendingMachineController;
import mmala.vendingmachine.dao.AuditDao;
import mmala.vendingmachine.dao.VendingMachineException;
import mmala.vendingmachine.dao.AuditDaoImpl;
import mmala.vendingmachine.dao.VendingMachineDao;
import mmala.vendingmachine.dao.VendingMachineDaoImpl;
import mmala.vendingmachine.service.VendingMachineService;
import mmala.vendingmachine.service.VendingMachineServiceImpl;
import mmala.vendingmachine.ui.UserIO;
import mmala.vendingmachine.ui.UserIOImpl;
import mmala.vendingmachine.ui.VendingMachineView;


/**
 *
 * @author salajrawi
 */
public class App {
    public static void main(String[] args) throws VendingMachineException{
        UserIO io = new UserIOImpl();
        VendingMachineView view = new VendingMachineView(io);
        AuditDao auditDao = new AuditDaoImpl();
        VendingMachineDao dao = new VendingMachineDaoImpl();
        VendingMachineService service = new VendingMachineServiceImpl(auditDao, dao);
        VendingMachineController controller = new VendingMachineController(view, service);
        
        controller.run();
        
    } 
}
