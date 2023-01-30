package kmp

import adw.G_APPLICATION_FLAGS_NONE
import adw.adw_application_new
import gtk4.*
import kotlinx.cinterop.*
import platform.posix.exit
import kotlin.reflect.KFunction1

fun main(vararg args: String) {
  commonMain(args = args)
  val app = adw_application_new("local.kmp", G_APPLICATION_FLAGS_NONE)!!
  val ref: StableRef<KFunction1<CPointer<GtkApplication>, Unit>> = StableRef.create(::buildUi)

  g_signal_connect_data(
    instance = app,
    detailed_signal = "activate",
    c_handler = staticCFunction<COpaquePointer, COpaquePointer, Unit> { self, r ->
      r.asStableRef<KFunction1<CPointer<GtkApplication>, Unit>>().get()(self.reinterpret())
    }.reinterpret(),
    data = ref.asCPointer(),
    destroy_data = null,
    connect_flags = G_APPLICATION_FLAGS_NONE
  )
  exit(g_application_run(app.reinterpret(), 0, null))
}

private fun buildUi(app: CPointer<GtkApplication>) {
  val window = gtk_application_window_new(app)!!
  val label = gtk_label_new("Hello World")!!
  gtk_window_set_title(window.reinterpret(), "Hello")
  gtk_window_set_default_size(window.reinterpret(), 200, 200)
  gtk_window_set_child(window.reinterpret(), label)
  gtk_window_present(window.reinterpret())
}
