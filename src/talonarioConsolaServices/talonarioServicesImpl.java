package talonarioConsolaServices; 

import java.util.LinkedList;
import java.util.List;
// 1. Corregido: Importación completa de la clase del modelo
import talonarioConsolaModel.talonarioModel; 

public class talonarioServicesImpl implements ITalonarioService {
	
	// 2. Corregido: Cambiado Talonario por talonarioModel
	private List<talonarioModel> talonarios;
	
	// 3. Corregido: El nombre del constructor debe ser EXACTO al de la clase
	public talonarioServicesImpl() {
		this.talonarios = new LinkedList<>();
	}

	@Override
	public boolean guardar(talonarioModel talonario) {
		return talonarios.add(talonario);
	}

	@Override
	public talonarioModel recuperar(talonarioModel talonario) {
		for (talonarioModel t : talonarios) {
			if (t.getId() == talonario.getId()) {
				return t;
			}
		}
		return null;
	}
	
	@Override
	public List<talonarioModel> recuperarTalonarios() {
		return talonarios;
	}

	@Override
	public talonarioModel modificar(talonarioModel talonario) {
		for (int i = 0; i < talonarios.size(); i++) {
			if (talonarios.get(i).getId() == talonario.getId()) {
				talonarios.set(i, talonario);
				return talonario;
			}
		}
		return null;
	}

	@Override
	public boolean eliminar(talonarioModel talonario) {
		return talonarios.removeIf(t -> t.getId() == talonario.getId());
	}
}