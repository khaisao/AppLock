package com.momentolabs.app.security.applocker.ui.permissions

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import com.momentolabs.app.security.applocker.R
import com.momentolabs.app.security.applocker.databinding.BottomSheetPermissionBinding
import com.momentolabs.app.security.applocker.ui.BaseBottomSheetDialog
import com.momentolabs.app.security.applocker.ui.rateus.RateUsViewModel
import com.momentolabs.app.security.applocker.util.delegate.inflate

class PermissionBottomSheet : BaseBottomSheetDialog<RateUsViewModel>() {
    private val binding: BottomSheetPermissionBinding by inflate(R.layout.bottom_sheet_permission)

    override fun getViewModel(): Class<RateUsViewModel> = RateUsViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.ivCloseBottomSheet.setOnClickListener {
            dialog.dismiss()
        }
        if (isCanDrawOverlayPermission()) {
            binding.swShowOverApp.isChecked = true
            binding.swShowOverApp.setOnClickListener {
            }
        } else {
            binding.swShowOverApp.isChecked = false
            binding.swShowOverApp.setOnClickListener {
                val packageName = requireContext().packageName
                val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:$packageName")
                )
                startActivity(intent)
            }
        }
        if (PermissionChecker.checkUsageAccessPermission(requireContext()).not()) {
            binding.swDetect.isChecked = false
            binding.swDetect.setOnClickListener {
                startActivity(IntentHelper.usageAccessIntent())
                dismiss()
            }
        } else {
            binding.swDetect.isChecked = true
            binding.swDetect.setOnClickListener {
            }
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()

    }

    companion object {
        fun newInstance(): AppCompatDialogFragment {
            val dialog = PermissionBottomSheet()
            dialog.isCancelable = false
            return dialog
        }
    }

    private fun isCanDrawOverlayPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= 30) {
            Settings.canDrawOverlays(requireContext())
        } else {
            true
        }
    }

}