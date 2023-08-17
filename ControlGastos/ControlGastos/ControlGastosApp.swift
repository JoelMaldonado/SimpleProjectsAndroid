//
//  ControlGastosApp.swift
//  ControlGastos
//
//  Created by Joel on 17/08/23.
//

import SwiftUI

@main
struct ControlGastosApp: App {
    let persistenceController = PersistenceController.shared

    var body: some Scene {
        WindowGroup {
            MenuScreen()
                .environment(\.managedObjectContext, persistenceController.container.viewContext)
                .environmentObject(DIContainer.shared.resolve(HomeViewModel.self))
                .environmentObject(DIContainer.shared.resolve(AgregarDeudaViewModel.self))
        }
    }
}
