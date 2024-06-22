package dl;

import java.util.List;

import dto.RegisDTO;

public interface RegisDAO {
  boolean insertRegisDetail(RegisDTO regisDTO);
  List<RegisDTO> fatchRegisdetail();
  RegisDTO fatchRegisdetail(String adhar);
}
