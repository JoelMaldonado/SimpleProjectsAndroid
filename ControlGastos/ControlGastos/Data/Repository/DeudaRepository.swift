//
//  DeudaRepository.swift
//  ControlGastos
//
//  Created by Joel on 17/08/23.
//

import Foundation

protocol DeudaRepository {
    func listarPruebas() -> [Deuda]
    func insert(deuda:Deuda)
    func delete(deuda:Deuda)
}
