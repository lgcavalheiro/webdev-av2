<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="modal" id="edit-modal">
  <div id="modal-content">
    <a class="close-btn" href="#">&times;</a>
    <div>
      <fieldset>
        <legend>TEST</legend>
        <form action="" method="" name="">
          <div class="AV1">
            <label for="trabalhoAV1">
              AV1 - Trabalho
              <input
                type="number"
                name="trabalhoAV1"
                id="trabalhoAV1"
                min="0"
                max="7"
                step="0.1"
                value=""
                required
              />
            </label>

            <label for="APSAV1">
              AV1 - APS
              <input
                type="number"
                name="APSAV1"
                id="APSAV1"
                min="0"
                max="3"
                step="0.1"
                value=""
                required
              />
            </label>
          </div>
          <div class="AV2">
            <label for="trabalhoAV2">
              AV2 - Trabalho
              <input
                type="number"
                name="trabalhoAV2"
                id="trabalhoAV2"
                min="0"
                max="8"
                step="0.1"
                value=""
                required
              />
            </label>
            <label for="APSAV2">
              AV2 - APS
              <input
                type="number"
                name="APSAV2"
                id="APSAV2"
                min="0"
                max="2"
                step="0.1"
                value=""
                required
              />
            </label>
          </div>
          <label for="trabalhoAV3">
            AV3 - Trabalho
            <input
              type="number"
              name="trabalhoAV3"
              id="trabalhoAV3"
              min="0"
              max="10"
              step="0.1"
              value=""
              required
            />
          </label>

          <input type="submit" value="Atualizar" />
        </form>
      </fieldset>
    </div>
  </div>
</div>
