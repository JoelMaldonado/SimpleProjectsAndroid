//
//  AgregarDeudaViewModel.swift
//  ControlGastos
//
//  Created by Joel on 17/08/23.
//

import Foundation
class AgregarDeudaViewModel : ObservableObject {
    
    private let useCase: DeudaUseCaseProtocol
    
    @Published var descrip: String = ""
    @Published var metodo: String = ""
    @Published var monto: String = ""
    
    
    init(useCase: DeudaUseCaseProtocol) {
        self.useCase = useCase
    }
    
    func insert(){
        let deuda = Deuda()
        deuda.descrip = descrip
        deuda.metodo = metodo
        deuda.monto = Double(monto) ?? 0
        useCase.insert(deuda: deuda)
    }
    
}
